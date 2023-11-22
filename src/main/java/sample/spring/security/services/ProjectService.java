package sample.spring.security.services;

import sample.spring.security.models.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAllProjects();

    Project createProject(Project project);

    Project updateProject(long project_code, Project project);

    void deleteProject(long project_code);

    Optional<Project> getProjectById(long project_code);
}
