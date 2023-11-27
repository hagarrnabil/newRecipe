package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.UnitFloor;
import sample.spring.security.models.UnitType;

import java.util.List;

public interface UnitTypeRepository extends JpaRepository<UnitType,Long> {
    @Query("SELECT u FROM UnitType u WHERE CONCAT(u.unitType_code, ' ', u.unitTypeDescription,' ', u.unitTypeID) LIKE %?1%")
    public List<UnitType> search(String keyword);
}
