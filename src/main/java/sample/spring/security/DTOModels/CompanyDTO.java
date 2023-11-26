package sample.spring.security.DTOModels;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class CompanyDTO {
    private Long company_code;

    private String companyCodeID;

    private String companyCodeDescription;

//    public CompanyDTO(Long company_code, String companyCodeID, String companyCodeDescription) {
//        this.company_code = company_code;
//        this.companyCodeID = companyCodeID;
//        this.companyCodeDescription = companyCodeDescription;
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
}
