package sample.spring.security.controllers;


import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Project;
import sample.spring.security.repositories.ProjectRepository;

import java.util.Optional;

@RestController
public class ProjectPostController {

    @Autowired
    private final ProjectRepository projectrepository;


    public ProjectPostController(ProjectRepository projectrepository) {
        this.projectrepository = projectrepository;
    }

    @GetMapping("/projects")
    Iterable<Project> all() {
        return projectrepository.findAll();
    }

    @RequestMapping(value = "/projects/{projectID}", method = RequestMethod.GET)
    public Optional<Project> findByIds(@PathVariable @NotNull Long projectID) {

        return projectrepository.findById(projectID);
    }

    @PostMapping("/projects")
    Project newProject(@RequestBody Project newProject) {
        return projectrepository.save(newProject);
    }

    @DeleteMapping("/projects/{projectID}")
    void deleteProject(@PathVariable Long projectID) {
        projectrepository.deleteById(projectID);
    }

    @PutMapping("/projects/{projectID}")
    Project updateProject(@RequestBody Project newProject, @PathVariable Long projectID) {

        return projectrepository.findById(projectID).map(project -> {
            project.setProjectID(newProject.getProjectID());
            project.setProjectDescription(newProject.getProjectDescription());
            project.setCompanyCodeDescription(newProject.getCompanyCodeDescription());
            project.setValidFrom(newProject.getValidFrom());
            project.setRegionalLocation(newProject.getRegionalLocation());
            project.setCompanyCodeID(newProject.getCompanyCodeID());
            return projectrepository.save(newProject);
        }).orElseGet(() -> {
            newProject.setProjectID(projectID);
            return projectrepository.save(newProject);
        });
    }


}
