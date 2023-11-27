package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.UnitOfMeasurements;

import java.util.List;

public interface UoMRepository extends JpaRepository<UnitOfMeasurements,Long> {
    @Query("SELECT u FROM UnitOfMeasurements u WHERE CONCAT(u.unitOfMeasurement_code, ' ', u.unitOfMeasurementDesc, ' ', u.unitOfMeasurementID) LIKE %?1%")
    public List<UnitOfMeasurements> search(String keyword);
}
