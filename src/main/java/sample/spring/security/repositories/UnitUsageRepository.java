package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.UnitUsage;

import java.util.List;

public interface UnitUsageRepository extends JpaRepository<UnitUsage,Long> {
    @Query("SELECT u FROM UnitUsage u WHERE CONCAT(u.unitUsage_code, ' ', u.unitUsageID, ' ', u.usageTypeDescription) LIKE %?1%")
    public List<UnitUsage> search(String keyword);
}
