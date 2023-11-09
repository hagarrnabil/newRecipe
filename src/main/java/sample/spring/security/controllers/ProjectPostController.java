package sample.spring.security.controllers;


import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Project;
import sample.spring.security.repositories.ProjectRepository;

import java.util.List;
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

    @RequestMapping(value = "/projects/{project_code}", method = RequestMethod.GET)
    public Optional<Project> findByIds(@PathVariable @NotNull Long project_code) {

        return projectrepository.findById(project_code);
    }

    @PostMapping("/projects")
    Project newProject(@RequestBody Project newProject) {
        return projectrepository.save(newProject);
    }

    @DeleteMapping("/projects/{project_code}")
    void deleteProject(@PathVariable Long project_code) {
        projectrepository.deleteById(project_code);
    }

    @PutMapping("/projects/{project_code}")
    Project updateProject(@RequestBody Project newProject, @PathVariable Long project_code) {

        return projectrepository.findById(project_code).map(project -> {
            project.setProject_code(newProject.getProject_code());
            project.setProjectID(newProject.getProjectID());
            project.setProjectDescription(newProject.getProjectDescription());
            project.setCompanyCodeDescription(newProject.getCompanyCodeDescription());
            project.setValidFrom(newProject.getValidFrom());
            project.setRegionalLocation(newProject.getRegionalLocation());
            project.setCompanyCodeID(newProject.getCompanyCodeID());
            return projectrepository.save(newProject);
        }).orElseGet(() -> {
            newProject.setProject_code(project_code);
            return projectrepository.save(newProject);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects/projectDescriptionsandregionalLocation")
    @ResponseBody
    public List<Project> Search(@RequestParam String projectDescription, @RequestParam String regionalLocation) {

        return projectrepository.findByProjectDescriptionAndRegionalLocation(projectDescription, regionalLocation);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/projects/search")
    @ResponseBody
    public List<Project> Search(@RequestParam String keyword) {

        return projectrepository.search(keyword);
    }

}
