package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.UnitStatus;

import java.util.List;

public interface UnitStatusRepository extends JpaRepository<UnitStatus,Long> {
    @Query("SELECT u FROM UnitStatus u WHERE CONCAT(u.unitStatus, ' ', u.unitStatus_code, ' ', u.unitStatusID) LIKE %?1%")
    public List<UnitStatus> search(String keyword);
}
