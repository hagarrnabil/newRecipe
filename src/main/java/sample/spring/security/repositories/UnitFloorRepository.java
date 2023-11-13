package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.UnitFloor;

import java.util.List;

public interface UnitFloorRepository extends JpaRepository<UnitFloor,Long> {
    @Query("SELECT u FROM UnitFloor u WHERE CONCAT(u.floor, ' ', u.unitFloor_code, ' ', u.unitFloorID) LIKE %?1%")
    public List<UnitFloor> search(String keyword);
}
