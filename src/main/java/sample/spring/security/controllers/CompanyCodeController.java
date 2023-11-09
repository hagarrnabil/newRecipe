package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.CompanyCode;
import sample.spring.security.models.Project;
import sample.spring.security.repositories.CompanyCodeRepository;
import sample.spring.security.repositories.ProjectRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class CompanyCodeController {

    @Autowired
    private final CompanyCodeRepository companyCodeRepository;

    public CompanyCodeController(CompanyCodeRepository companyCodeRepository) {
        this.companyCodeRepository = companyCodeRepository;
    }

    @GetMapping("/companycode")
    Iterable<CompanyCode> all() {
        return companyCodeRepository.findAll();
    }

    @RequestMapping(value = "/companycode/{company_code}", method = RequestMethod.GET)
    public Optional<CompanyCode> findByIds(@PathVariable @NotNull Long company_code) {

        return companyCodeRepository.findById(company_code);
    }

    @PostMapping("/companycode")
    CompanyCode newCompanyCode(@RequestBody CompanyCode newCompanyCode) {
        return companyCodeRepository.save(newCompanyCode);
    }

    @DeleteMapping("/companycode/{company_code}")
    void deleteCompanyCode(@PathVariable Long company_code) {
        companyCodeRepository.deleteById(company_code);
    }

    @PutMapping("/companycode/{company_code}")
    CompanyCode updateCompanyCode(@RequestBody CompanyCode newCompanyCode, @PathVariable Long company_code) {

        return companyCodeRepository.findById(company_code).map(companyCode -> {
            companyCode.setCompany_code(newCompanyCode.getCompany_code());
            companyCode.setCompanyCodeDescription(newCompanyCode.getCompanyCodeDescription());
            companyCode.setCompanyCodeID(newCompanyCode.getCompanyCodeID());
            return companyCodeRepository.save(newCompanyCode);
        }).orElseGet(() -> {
            newCompanyCode.setCompany_code(company_code);
            return companyCodeRepository.save(newCompanyCode);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/companycode/search")
    @ResponseBody
    public List<CompanyCode> Search(@RequestParam String keyword) {

        return companyCodeRepository.search(keyword);
    }

}
