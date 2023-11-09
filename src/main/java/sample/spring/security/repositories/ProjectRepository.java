package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Project;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, Long>{
    List<Project> findByProjectDescriptionAndRegionalLocation(String projectDescription, String regionalLocation);
    @Query("SELECT p FROM Project p WHERE CONCAT(p.project_code, ' ', p.projectID, ' ', p.projectDescription, ' ', p.companyCodeDescription, ' '," +
            " p.companyCodeID, ' ', p.regionalLocation, ' ', p.validFrom) LIKE %?1%")
    public List<Project> search(String keyword);

}


