package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Unit;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit,Long> {
    @Query("SELECT u FROM Unit u WHERE CONCAT(u.Amount, ' ', u.blockingDate, ' ', u.blockingReason, ' '," +
            " u.builtUpArea, ' ', u.conditionCode, ' ', u.conditionDescription, ' ', u.constructionDate" +
            ", ' ', u.description, ' ', u.destination, ' ', u.fixture, ' ', u.gardenArea, ' '," +
            "u.measurements, ' ', u.measurementsDescription, ' ', u.measurementsID, ' ' , u.measurementValue" +
            ", ' ', u.numberOfRooms, ' ', u.oldNumber, ' ', u.orientation, ' ', u.price, ' ', u.pricePlan" +
            ", ' ' ,u.pricingTab, ' ' , u.salesPhase, ' ' ,u.unitKey, ' ', u.toFloor, ' ', u.unitAdditionalPayment" +
            ", ' ', u.unit_code, ' ', u.unitOfMeasurement, ' ', u.unitType, ' ', u.project) LIKE %?1%")
    public List<Unit> search(String keyword);

}
