package sample.spring.security.services;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import sample.spring.security.models.CompanyMD;
import sample.spring.security.models.Project;
import sample.spring.security.repositories.CompanyRepository;
import sample.spring.security.repositories.ProjectRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService{
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        super();
        this.projectRepository = projectRepository;
    }


    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project createProject(Project project) {
//        CompanyMD companyMD = new CompanyMD();
//        project.setCompanyMD(companyMD);
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(long project_code, Project project) {

        return projectRepository.findById(project_code).map(project1 -> {
            project1.setProjectDescription(project.getProjectDescription());
            project1.setProjectID(project.getProjectID());
            project1.setProject_code(project.getProject_code());
            project1.setValidFrom(project.getValidFrom());
            return projectRepository.save(project);
        }).orElseGet(() -> {
            project.setProject_code(project_code);
            return projectRepository.save(project);
        });
    }

    @Override
    public void deleteProject(long project_code) {
        projectRepository.deleteById(project_code);
    }

    @Override
    public Optional<Project> getProjectById(long project_code) {
        return projectRepository.findById(project_code);
    }

}

