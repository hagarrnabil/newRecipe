package sample.spring.security.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
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
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validFrom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_code", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty("company_code")
    private CompanyMD companyMD;

    @OneToMany(mappedBy = "project")
    private final Set<Building> buildings;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "projects_profit", joinColumns = {@JoinColumn(name = "project_code")},
            inverseJoinColumns = {@JoinColumn(name = "profit_code")})
    Set < Profit > profits = new HashSet < Profit > ();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "projects_cities", joinColumns = {@JoinColumn(name = "project_code")},
            inverseJoinColumns = {@JoinColumn(name = "cities_code")})
    Set < Cities > citiesSet = new HashSet < Cities > ();


    public Project(Set<Building> buildings) {
        this.buildings = buildings;
    }

//    public Project() {
//
//        buildings = null;
//    }

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
                ", validFrom=" + validFrom +
                ", companyMD=" + companyMD +
                '}';
    }
}