package sample.spring.security.services;

import org.springframework.stereotype.Service;
import sample.spring.security.models.CompanyMD;
import sample.spring.security.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServieImpl implements CompanyService{
    private final CompanyRepository companyRepository;

    public CompanyServieImpl(CompanyRepository companyRepository) {
        super();
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyMD> getAllCompanyMD() {
        return companyRepository.findAll();
    }

    @Override
    public CompanyMD createCompanyMD(CompanyMD companyMD) {
        return companyRepository.save(companyMD);
    }

    @Override
    public CompanyMD updateCompanyMD(long company_code, CompanyMD companyMD) {
        return companyRepository.findById(company_code).map(companyMD1 -> {
            companyMD1.setCompany_code(companyMD.getCompany_code());
            companyMD1.setCompanyCodeID(companyMD.getCompanyCodeID());
            companyMD1.setCompanyCodeDescription(companyMD.getCompanyCodeDescription());
            return companyRepository.save(companyMD);
        }).orElseGet(() -> {
            companyMD.setCompany_code(company_code);
            return companyRepository.save(companyMD);
        });
    }

    @Override
    public void deleteCompanyMD(long company_code) {
        companyRepository.deleteById(company_code);
    }

    @Override
    public Optional<CompanyMD> getCompanyMDById(long company_code) {
        return companyRepository.findById(company_code);
    }
}
