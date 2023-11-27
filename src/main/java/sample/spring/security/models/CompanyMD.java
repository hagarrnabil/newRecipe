package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "companyMD")
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class CompanyMD implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setCompanyCodeDescription(String companyCodeDescription) {
        this.companyCodeDescription = companyCodeDescription;
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