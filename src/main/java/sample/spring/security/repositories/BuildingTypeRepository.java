package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.BuildingType;

import java.util.List;

public interface BuildingTypeRepository extends JpaRepository<BuildingType,Long> {
    @Query("SELECT b FROM BuildingType b WHERE CONCAT(b.buildTypeDesc, ' ', b.buildingTypeID, ' ', b.buildingType_code) LIKE %?1%")
    public List<BuildingType> search(String keyword);
}
