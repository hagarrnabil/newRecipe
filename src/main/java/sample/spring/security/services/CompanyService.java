package sample.spring.security.services;

import sample.spring.security.models.CompanyMD;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<CompanyMD> getAllCompanyMD();

    CompanyMD createCompanyMD(CompanyMD companyMD);

    CompanyMD updateCompanyMD(long company_code, CompanyMD companyMD);

    void deleteCompanyMD(long company_code);

    Optional<CompanyMD> getCompanyMDById(long company_code);
}

