package sample.spring.security.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "project_code")
    private Long project_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String projectID;
    @NotNull
    private String projectDescription;
    private Integer companyCodeID;
    private String companyCodeDescription;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validFrom;
    private String regionalLocation;

    public Project(Long project_code, String projectID, String projectDescription, Integer companyCodeID, String companyCodeDescription, Date validFrom, String regionalLocation) {
        this.project_code = project_code;
        this.projectID = projectID;
        this.projectDescription = projectDescription;
        this.companyCodeID = companyCodeID;
        this.companyCodeDescription = companyCodeDescription;
        this.validFrom = validFrom;
        this.regionalLocation = regionalLocation;
    }

    public Project() {

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

    public Integer getCompanyCodeID() {
        return companyCodeID;
    }

    public void setCompanyCodeID(Integer companyCodeID) {
        this.companyCodeID = companyCodeID;
    }

    public String getCompanyCodeDescription() {
        return companyCodeDescription;
    }

    public void setCompanyCodeDescription(String companyCodeDescription) {
        this.companyCodeDescription = companyCodeDescription;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public String getRegionalLocation() {
        return regionalLocation;
    }

    public void setRegionalLocation(String regionalLocation) {
        this.regionalLocation = regionalLocation;
    }

    @Override
    public String toString() {
        return "Project{" +
                "project_code=" + project_code +
                ", projectID='" + projectID + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", companyCodeID=" + companyCodeID +
                ", companyCodeDescription='" + companyCodeDescription + '\'' +
                ", validFrom=" + validFrom +
                ", regionalLocation='" + regionalLocation + '\'' +
                '}';
    }
}