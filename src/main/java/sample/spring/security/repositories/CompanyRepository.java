package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.CompanyMD;

import java.util.List;

public interface CompanyRepository extends JpaRepository<CompanyMD, Long> {
    @Query("SELECT c FROM CompanyMD c WHERE CONCAT(c.companyCodeDescription, ' ', c.companyCodeID, ' ', c.company_code) LIKE %?1%")
    public List<CompanyMD> search(String keyword);
}
