package sample.spring.security.repositories;

import org.springframework.data.repository.CrudRepository;
import sample.spring.security.models.Unit;

import java.math.BigInteger;

public interface UnitRepository extends CrudRepository<Unit, Long> {

}
