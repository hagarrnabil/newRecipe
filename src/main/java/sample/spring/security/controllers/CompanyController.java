package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.DTOModels.CompanyDTO;
import sample.spring.security.DTOModels.ProjectDTO;
import sample.spring.security.models.CompanyMD;
import sample.spring.security.models.Project;
import sample.spring.security.repositories.CompanyRepository;
import sample.spring.security.services.CompanyService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CompanyController {

//     @Autowired
//     private final CompanyRepository companyRepository;
     @Autowired
     private ModelMapper modelMapper;
     private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        super();
        this.companyService = companyService;
    }

    @GetMapping("/companymd")
    public List<CompanyDTO> getAllCompanyMD() {

        return companyService.getAllCompanyMD().stream().map(companyMD -> modelMapper.map(companyMD, CompanyDTO.class))
                .collect(Collectors.toList());
    }
    @GetMapping("/companymd/{company_code}")
    public ResponseEntity<CompanyDTO> getCompanyMDtById(@PathVariable(name = "company_code") Long company_code) {
        Optional<CompanyMD> companyMD = companyService.getCompanyMDById(company_code);

        // convert entity to DTO
        CompanyDTO companyResponse = modelMapper.map(companyMD, CompanyDTO.class);

        return ResponseEntity.ok().body(companyResponse);
    }


    @PostMapping("/companymd")
    public ResponseEntity<CompanyDTO> createCompanyMD(@RequestBody CompanyDTO companyDTO) {

        // convert DTO to entity
        CompanyMD companyRequest = modelMapper.map(companyDTO, CompanyMD.class);

        CompanyMD companyMD = companyService.createCompanyMD(companyRequest);

        // convert entity to DTO
        CompanyDTO companyResponse = modelMapper.map(companyMD, CompanyDTO.class);

        return new ResponseEntity<CompanyDTO>(companyResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/companymd/{company_code}")
    void deleteCompanyMD(@PathVariable Long company_code) {
        companyService.deleteCompanyMD(company_code);
    }

    @PutMapping("/companymd/{company_code}")
    public ResponseEntity<CompanyDTO> updateCompanyMD(@PathVariable long company_code, @RequestBody CompanyDTO companyDTO) {

        // convert DTO to Entity
        CompanyMD companyRequest = modelMapper.map(companyDTO, CompanyMD.class);

        CompanyMD companyMD = companyService.updateCompanyMD(company_code, companyRequest);

        // entity to DTO
        CompanyDTO companyResponse = modelMapper.map(companyMD, CompanyDTO.class);

        return ResponseEntity.ok().body(companyResponse);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/companymd/search")
//    @ResponseBody
//    public List<CompanyMD> Search(@RequestParam String keyword) {
//
//        return companyRepository.search(keyword);
//    }

}
