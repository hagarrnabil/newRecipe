package sample.spring.security.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "companyCode")
public class CompanyCode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_code")
    private Long company_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String companyCodeID;
    @NotNull
    private String companyCodeDescription;
    @OneToMany(mappedBy = "companycode")
    private final Set<Project> projects;
    @OneToMany(mappedBy = "companycode")
    private final Set<Unit> units;

    public CompanyCode() {
        projects = null;
        units = null;
    }

    public CompanyCode(Long company_code, String companyCodeID, String companyCodeDescription, Set<Project> projects, Set<Unit> units) {
        this.company_code = company_code;
        this.companyCodeID = companyCodeID;
        this.companyCodeDescription = companyCodeDescription;
        this.projects = projects;
        this.units = units;
    }

    public Long getCompany_code() {
        return company_code;
    }

    public void setCompany_code(Long company_code) {
        this.company_code = company_code;
    }

    public String getCompanyCodeID() {
        return companyCodeID;
    }

    public void setCompanyCodeID(String companyCodeID) {
        this.companyCodeID = companyCodeID;
    }

    public String getCompanyCodeDescription() {
        return companyCodeDescription;
    }

    public void setCompanyCodeDescription(String companyCodeDescription) {
        this.companyCodeDescription = companyCodeDescription;
    }
    @JsonManagedReference
    public Set<Project> getProjects() {
        return projects;
    }
    @JsonManagedReference
    public Set<Unit> getUnits() {
        return units;
    }

    @Override
    public String toString() {
        return "CompanyCode{" +
                "company_code=" + company_code +
                ", companyCodeID='" + companyCodeID + '\'' +
                ", companyCodeDescription='" + companyCodeDescription + '\'' +
                '}';
    }
}
