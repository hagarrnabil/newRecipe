package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.CompanyMD;
import sample.spring.security.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyController {

    @Autowired
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/companymd")
    Iterable<CompanyMD> all() {
        return companyRepository.findAll();
    }

    @RequestMapping(value = "/companymd/{company_code}", method = RequestMethod.GET)
    public Optional<CompanyMD> findByIds(@PathVariable @NotNull Long company_code) {

        return companyRepository.findById(company_code);
    }

    @PostMapping("/companymd")
    CompanyMD newCompanyCode(@RequestBody CompanyMD newCompanyCode) {
        return companyRepository.save(newCompanyCode);
    }

    @DeleteMapping("/companymd/{company_code}")
    void deleteCompanyCode(@PathVariable Long company_code) {
        companyRepository.deleteById(company_code);
    }

    @PutMapping("/companymd/{company_code}")
    CompanyMD updateCompanyCode(@RequestBody CompanyMD newCompanyCode, @PathVariable Long company_code) {

        return companyRepository.findById(company_code).map(companyCode -> {
            companyCode.setCompany_code(newCompanyCode.getCompany_code());
            companyCode.setCompanyCodeDescription(newCompanyCode.getCompanyCodeDescription());
            companyCode.setCompanyCodeID(newCompanyCode.getCompanyCodeID());
            return companyRepository.save(newCompanyCode);
        }).orElseGet(() -> {
            newCompanyCode.setCompany_code(company_code);
            return companyRepository.save(newCompanyCode);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/companymd/search")
    @ResponseBody
    public List<CompanyMD> Search(@RequestParam String keyword) {

        return companyRepository.search(keyword);
    }

}
