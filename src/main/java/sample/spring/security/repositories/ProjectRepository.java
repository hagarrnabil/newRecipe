package sample.spring.security.repositories;

import org.springframework.data.repository.CrudRepository;
import sample.spring.security.models.Project;



public interface ProjectRepository extends CrudRepository<Project, Long> {

}
