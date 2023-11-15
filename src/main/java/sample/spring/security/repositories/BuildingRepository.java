package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Building;

import java.util.List;

public interface BuildingRepository extends JpaRepository<Building,Long> {
    @Query("SELECT b FROM Building b WHERE CONCAT(b.validFrom, ' ', b.oldNumber, ' ', b.numberOfFloors, ' ', b.buildingID, ' ', b.buildingDescription, ' ', b.building_code, ' ', b.project, ' ',b.units) LIKE %?1%")
    public List<Building> search(String keyword);
}
