package sample.spring.security.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "projects")
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "projectID")
    private Long projectID;
    private String projectDescription;
    private Integer companyCodeID;
    private String companyCodeDescription;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validFrom;
    private String regionalLocation;

    public Project(Long projectID, String projectDescription, Integer companyCodeID, String companyCodeDescription, Date validFrom, String regionalLocation) {
        this.projectID = projectID;
        this.projectDescription = projectDescription;
        this.companyCodeID = companyCodeID;
        this.companyCodeDescription = companyCodeDescription;
        this.validFrom = validFrom;
        this.regionalLocation = regionalLocation;
    }

    public Project() {

    }

    public Long getProjectID() {
        return projectID;
    }

    public void setProjectID(Long projectID) {
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
                "projectID=" + projectID +
                ", projectDescription='" + projectDescription + '\'' +
                ", companyCodeID=" + companyCodeID +
                ", companyCodeDescription='" + companyCodeDescription + '\'' +
                ", validFrom=" + validFrom +
                ", regionalLocation='" + regionalLocation + '\'' +
                '}';
    }
}
