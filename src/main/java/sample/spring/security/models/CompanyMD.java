package sample.spring.security.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "companyMD")
@Data
@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CompanyMD implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "company_code")
    private Long company_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String companyCodeID;
    @NotNull
    private String companyCodeDescription;

    @OneToMany(mappedBy = "companyMD")
    private final Set<Project> projects;

    public CompanyMD(Set<Project> projects) {
        this.projects = projects;
    }

//    public CompanyMD addProject (Project project) {
//        projects.add(project);
//        project.setCompanyMD(this);
//        return this;
//    }

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

    @Override
    public String toString() {
        return "CompanyMD{" +
                "company_code=" + company_code +
                ", companyCodeID='" + companyCodeID + '\'' +
                ", companyCodeDescription='" + companyCodeDescription + '\'' +
                '}';
    }
}
