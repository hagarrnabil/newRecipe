package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Cities;
import sample.spring.security.models.UnitAreaDetails;

import java.util.List;

public interface UADRepository extends JpaRepository<UnitAreaDetails,Long> {
    @Query("SELECT u FROM UnitAreaDetails u WHERE CONCAT(u.areaID, ' ',u.area, ' ',u.noOfRooms, ' ',u.area_code,' ',u.amount) LIKE %?1%")
    public List<UnitAreaDetails> search(String keyword);
}
