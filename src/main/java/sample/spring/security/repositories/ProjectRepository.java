package sample.spring.security.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import sample.spring.security.models.Project;

import java.util.List;


public interface ProjectRepository extends JpaRepository<Project, Long> {
   // List<Project> findByProjectDescription(String projectDescription);
    List<Project> findByProjectDescriptionAndRegionalLocation(String projectDescription, String regionalLocation);
}


