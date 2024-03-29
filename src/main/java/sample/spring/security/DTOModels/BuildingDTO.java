package sample.spring.security.DTOModels;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
public class BuildingDTO {
    private Long building_code;
    private String buildingID;
    private String buildingDescription;
    private String oldNumber;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validFrom;
    private Integer numberOfFloors;
    private Long project_code;
    private String buildTypeDesc;


//    public BuildingDTO(Long building_code, String buildingID, String buildingDescription, String oldNumber, Date validFrom, Integer numberOfFloors, Long project_code) {
//        this.building_code = building_code;
//        this.buildingID = buildingID;
//        this.buildingDescription = buildingDescription;
//        this.oldNumber = oldNumber;
//        this.validFrom = validFrom;
//        this.numberOfFloors = numberOfFloors;
//        this.project_code = project_code;
//    }

    public String getBuildTypeDesc() {
        return buildTypeDesc;
    }

    public void setBuildTypeDesc(String buildTypeDesc) {
        this.buildTypeDesc = buildTypeDesc;
    }

    public Long getBuilding_code() {
        return building_code;
    }

    public void setBuilding_code(Long building_code) {
        this.building_code = building_code;
    }

    public String getBuildingID() {
        return buildingID;
    }

    public void setBuildingID(String buildingID) {
        this.buildingID = buildingID;
    }

    public String getBuildingDescription() {
        return buildingDescription;
    }

    public void setBuildingDescription(String buildingDescription) {
        this.buildingDescription = buildingDescription;
    }

    public String getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(String oldNumber) {
        this.oldNumber = oldNumber;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Long getProject_code() {
        return project_code;
    }

    public void setProject_code(Long project_code) {
        this.project_code = project_code;
    }
}
