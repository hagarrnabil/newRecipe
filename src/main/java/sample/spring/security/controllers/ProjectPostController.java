package sample.spring.security.controllers;


import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Project;
import sample.spring.security.repositories.CompanyRepository;
import sample.spring.security.repositories.ProjectRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectPostController {

    @Autowired
    private final CompanyRepository companyRepository;
    @Autowired
    private final ProjectRepository projectrepository;

    public ProjectPostController(CompanyRepository companyRepository, ProjectRepository projectrepository) {
        this.companyRepository = companyRepository;
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

    @PostMapping("/companymd/{company_code}/projects")
    Project newProject(@PathVariable(value = "company_code") Long company_code, @RequestBody Project newProject) {
        return companyRepository.findById(company_code).map(companyMD -> {
            newProject.setCompanyMD(companyMD);
            return projectrepository.save(newProject);
        }).orElseThrow(() -> new RuntimeException("PostId " + company_code + " not found"));
    }

    @DeleteMapping("/projects/{project_code}")
    void deleteProject(@PathVariable Long project_code) {
        projectrepository.deleteById(project_code);
    }


    @PutMapping("/companymd/{company_code}/projects/{project_code}")
    Project updateProject(@RequestBody Project newProject, @PathVariable Long project_code, @PathVariable Long company_code) {

        return companyRepository.findById(company_code).map(companyMD -> {
            newProject.setCompanyMD(companyMD);
            projectrepository.save(newProject);
            return projectrepository.findById(project_code).map(project -> {
                project.setProjectID(newProject.getProjectID());
                project.setProject_code(newProject.getProject_code());
                project.setProjectDescription(newProject.getProjectDescription());
                project.setValidFrom(newProject.getValidFrom());
                return projectrepository.save(newProject);
            }).orElseThrow(() -> new RuntimeException("PostId " + project_code + " not found"));
        }).orElseThrow(() -> new RuntimeException("PostId " + company_code + " not found"));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/projects/search")
    @ResponseBody
    public List<Project> Search(@RequestParam String keyword) {

        return projectrepository.search(keyword);
    }

}
