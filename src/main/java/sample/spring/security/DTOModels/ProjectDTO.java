package sample.spring.security.DTOModels;

import lombok.NoArgsConstructor;

import java.util.Date;
@NoArgsConstructor
public class ProjectDTO {
    private Long project_code;
    private String projectID;
    private String projectDescription;
    private Date validFrom;
    private Long company_code;

    public ProjectDTO(Long project_code, String projectID, String projectDescription, Date validFrom, Long company_code) {
        this.project_code = project_code;
        this.projectID = projectID;
        this.projectDescription = projectDescription;
        this.validFrom = validFrom;
        this.company_code = company_code;
    }

    public Long getProject_code() {
        return project_code;
    }

    public void setProject_code(Long project_code) {
        this.project_code = project_code;
    }

    public String getProjectID() {
        return projectID;
    }

    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Long getCompany_code() {
        return company_code;
    }

    public void setCompany_code(Long company_code) {
        this.company_code = company_code;
    }
}
