package sample.spring.security.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.DTOModels.ProjectDTO;
import sample.spring.security.models.CompanyMD;
import sample.spring.security.models.Project;
import sample.spring.security.repositories.CompanyRepository;
import sample.spring.security.repositories.ProjectRepository;
import sample.spring.security.services.CompanyService;
import sample.spring.security.services.CompanyServieImpl;
import sample.spring.security.services.ProjectService;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
public class ProjectPostController {

    @Autowired
    private ModelMapper modelMapper;
//    @Autowired
//    private final ProjectRepository projectrepository;
    private ProjectService projectService;

    public ProjectPostController(ProjectService projectService) {
        super();
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
//        System.out.println("project dto output"+projectDTO);

        // convert DTO to entity
        Project projectRequest = modelMapper.map(projectDTO, Project.class);

//        CompanyMD companyMD = new CompanyMD();
//        companyMD.setCompany_code(projectDTO.getCompany_code());
//        companyMD.setCompanyCodeID("company1");
//        companyMD.setCompanyCodeDescription("company 1");
//        CompanyService companyService = new CompanyServieImpl(new CompanyRepository() {
//            @Override
//            public void flush() {
//
//            }
//
//            @Override
//            public <S extends CompanyMD> S saveAndFlush(S entity) {
//                return null;
//            }
//
//            @Override
//            public <S extends CompanyMD> List<S> saveAllAndFlush(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public void deleteAllInBatch(Iterable<CompanyMD> entities) {
//
//            }
//
//            @Override
//            public void deleteAllByIdInBatch(Iterable<Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAllInBatch() {
//
//            }
//
//            @Override
//            public CompanyMD getOne(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public CompanyMD getById(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public CompanyMD getReferenceById(Long aLong) {
//                return null;
//            }
//
//            @Override
//            public <S extends CompanyMD> List<S> findAll(Example<S> example) {
//                return null;
//            }
//
//            @Override
//            public <S extends CompanyMD> List<S> findAll(Example<S> example, Sort sort) {
//                return null;
//            }
//
//            @Override
//            public <S extends CompanyMD> List<S> saveAll(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public List<CompanyMD> findAll() {
//                return null;
//            }
//
//            @Override
//            public List<CompanyMD> findAllById(Iterable<Long> longs) {
//                return null;
//            }
//
//            @Override
//            public <S extends CompanyMD> S save(S entity) {
//                return null;
//            }
//
//            @Override
//            public Optional<CompanyMD> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(CompanyMD entity) {
//
//            }
//
//            @Override
//            public void deleteAllById(Iterable<? extends Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends CompanyMD> entities) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//
//            @Override
//            public List<CompanyMD> findAll(Sort sort) {
//                return null;
//            }
//
//            @Override
//            public Page<CompanyMD> findAll(Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends CompanyMD> Optional<S> findOne(Example<S> example) {
//                return Optional.empty();
//            }
//
//            @Override
//            public <S extends CompanyMD> Page<S> findAll(Example<S> example, Pageable pageable) {
//                return null;
//            }
//
//            @Override
//            public <S extends CompanyMD> long count(Example<S> example) {
//                return 0;
//            }
//
//            @Override
//            public <S extends CompanyMD> boolean exists(Example<S> example) {
//                return false;
//            }
//
//            @Override
//            public <S extends CompanyMD, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
//                return null;
//            }
//        });
//
//        projectRequest.setCompanyMD(companyService.getCompanyMDById(projectDTO.getCompany_code()));
//        System.out.println("project request output"+projectRequest);
        Project project = projectService.createProject(projectRequest);

//        System.out.println("project output"+project);
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



//    @RequestMapping(method = RequestMethod.GET, value = "/projects/search")
//    @ResponseBody
//    public List<Project> Search(@RequestParam String keyword) {
//
//        return projectrepository.search(keyword);
//    }


}
