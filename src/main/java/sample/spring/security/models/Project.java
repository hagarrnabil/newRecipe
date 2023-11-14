package sample.spring.security.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "projects")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
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
    private String companyCodeDescription;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validFrom;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_code", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty("companyCode")
    private CompanyMD companyMD;
    @OneToMany(mappedBy = "project")
    private final Set<Unit> units;

    public Project(Long project_code, String projectID, String projectDescription, String companyCodeDescription, Date validFrom, CompanyMD companyMD, Set<Unit> units) {
        this.project_code = project_code;
        this.projectID = projectID;
        this.projectDescription = projectDescription;
        this.companyCodeDescription = companyCodeDescription;
        this.validFrom = validFrom;
        this.companyMD = companyMD;
        this.units = units;
    }

    public Project() {

        units = null;
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

    @JsonBackReference
    public CompanyMD getCompanyMD() {
        return companyMD;
    }
    @JsonBackReference
    public void setCompanyMD(CompanyMD companyMD) {
        this.companyMD = companyMD;
    }

    @JsonManagedReference
    public Set<Unit> getUnits() {
        return units;
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


    @Override
    public String toString() {
        return "Project{" +
                "project_code=" + project_code +
                ", projectID='" + projectID + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", companyCodeDescription='" + companyCodeDescription + '\'' +
                ", validFrom=" + validFrom +
                ", companyMD=" + companyMD +
                ", units=" + units +
                '}';
    }
}