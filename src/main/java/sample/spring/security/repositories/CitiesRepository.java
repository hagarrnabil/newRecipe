package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Cities;

import java.util.List;

public interface CitiesRepository extends JpaRepository<Cities, Long> {
    @Query("SELECT c FROM Cities c WHERE CONCAT(c.citiesID, ' ', c.cities_code, ' ', c.regionalLocation) LIKE %?1%")
    public List<Cities> search(String keyword);
}
