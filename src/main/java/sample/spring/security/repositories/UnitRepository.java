package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sample.spring.security.models.Project;
import sample.spring.security.models.Unit;

import java.math.BigInteger;
import java.util.List;

public interface UnitRepository extends JpaRepository<Unit,Long> {
 //   List<Unit> findByDescription(String description);
    List<Unit> findByUnitTypeAndView(String unitType, String view);
}
