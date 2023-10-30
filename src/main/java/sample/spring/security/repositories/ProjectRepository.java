package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sample.spring.security.models.Project;

import java.util.List;


public interface ProjectRepository extends CrudRepository<Project, Long> , JpaRepository<Project, Long> {

    List<Project> findByText(String description);
    List<Project> findByCompanyDescrAndLocation(String companyDescription, String location);
}
