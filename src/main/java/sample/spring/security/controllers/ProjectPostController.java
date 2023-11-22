package sample.spring.security.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.DTOModels.ProjectDTO;
import sample.spring.security.models.Project;
import sample.spring.security.repositories.ProjectRepository;
import sample.spring.security.services.ProjectService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class ProjectPostController {

    @Autowired
    private final ModelMapper modelMapper;
    @Autowired
    private final ProjectRepository projectrepository;
    private ProjectService projectService;

    public ProjectPostController(ModelMapper modelMapper, ProjectRepository projectrepository, ProjectService projectService) {
        super();
        this.modelMapper = modelMapper;
        this.projectrepository = projectrepository;
        this.projectService = projectService;
    }

    @GetMapping("/projects")
    public List<ProjectDTO> getAllProjects() {

        return projectService.getAllProjects().stream().map(project -> modelMapper.map(project, ProjectDTO.class))
                .collect(Collectors.toList());
    }


    @GetMapping("/projects/{project_code}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable(name = "project_code") Long project_code) {
        Optional<Project> project = projectService.getProjectById(project_code);

        // convert entity to DTO
        ProjectDTO projectResponse = modelMapper.map(project, ProjectDTO.class);

        return ResponseEntity.ok().body(projectResponse);
    }



    @PostMapping("/projects")
    public ResponseEntity<ProjectDTO> createProject(@RequestBody ProjectDTO projectDTO) {

        // convert DTO to entity
        Project projectRequest = modelMapper.map(projectDTO, Project.class);

        Project project = projectService.createProject(projectRequest);

        // convert entity to DTO
        ProjectDTO projectResponse = modelMapper.map(project, ProjectDTO.class);

        return new ResponseEntity<ProjectDTO>(projectResponse, HttpStatus.CREATED);
    }


    @DeleteMapping("/projects/{project_code}")
    void deleteProject(@PathVariable Long project_code) {
        projectService.deleteProject(project_code);
    }


    @PutMapping("/projects/{project_code}")
    public ResponseEntity<ProjectDTO> updateProject(@PathVariable long project_code, @RequestBody ProjectDTO projectDTO) {

        // convert DTO to Entity
        Project projectRequest = modelMapper.map(projectDTO, Project.class);

        Project project = projectService.updateProject(project_code, projectRequest);

        // entity to DTO
        ProjectDTO projectResponse = modelMapper.map(project, ProjectDTO.class);

        return ResponseEntity.ok().body(projectResponse);
    }



    @RequestMapping(method = RequestMethod.GET, value = "/projects/search")
    @ResponseBody
    public List<Project> Search(@RequestParam String keyword) {

        return projectrepository.search(keyword);
    }


}
