package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Cities;
import sample.spring.security.models.CompanyCode;

import java.util.List;

public interface CompanyCodeRepository extends JpaRepository<CompanyCode, Long> {
    @Query("SELECT c FROM CompanyCode c WHERE CONCAT(c.companyCodeDescription, ' ', c.companyCodeID, ' ', c.company_code) LIKE %?1%")
    public List<CompanyCode> search(String keyword);
}
