package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Entity
@Table(name = "companyCode")
public class CompanyCode implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_code")
    private Long company_code;

    @NotNull
    @Column(unique = true)
    private char companyCodeID;
    @NotNull
    private String companyCodeDescription;

    public CompanyCode() {
    }


    public CompanyCode(Long company_code, char companyCodeID, String companyCodeDescription) {
        this.company_code = company_code;
        this.companyCodeID = companyCodeID;
        this.companyCodeDescription = companyCodeDescription;
    }


    public Long getCompany_code() {
        return company_code;
    }

    public void setCompany_code(Long company_code) {
        this.company_code = company_code;
    }

    public char getCompanyCodeID() {
        return companyCodeID;
    }

    public void setCompanyCodeID(char companyCodeID) {
        this.companyCodeID = companyCodeID;
    }

    public String getCompanyCodeDescription() {
        return companyCodeDescription;
    }

    public void setCompanyCodeDescription(String companyCodeDescription) {
        this.companyCodeDescription = companyCodeDescription;
    }

    @Override
    public String toString() {
        return "CompanyCode{" +
                "company_code=" + company_code +
                ", companyCodeID=" + companyCodeID +
                ", companyCodeDescription='" + companyCodeDescription + '\'' +
                '}';
    }
}
