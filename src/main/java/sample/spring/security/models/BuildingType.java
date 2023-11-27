package sample.spring.security.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "buildingType")
public class BuildingType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buildingType_code")
    private Long buildingType_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String buildingTypeID;
    @NotNull
    private String buildTypeDesc;


    public BuildingType() {
    }

    public BuildingType(Long buildingType_code, String buildingTypeID, String buildTypeDesc) {
        this.buildingType_code = buildingType_code;
        this.buildingTypeID = buildingTypeID;
        this.buildTypeDesc = buildTypeDesc;
    }

    public Long getBuildingType_code() {
        return buildingType_code;
    }

    public void setBuildingType_code(Long buildingType_code) {
        this.buildingType_code = buildingType_code;
    }

    public String getBuildingTypeID() {
        return buildingTypeID;
    }

    public void setBuildingTypeID(String buildingTypeID) {
        this.buildingTypeID = buildingTypeID;
    }

    public String getBuildTypeDesc() {
        return buildTypeDesc;
    }

    public void setBuildTypeDesc(String buildTypeDesc) {
        this.buildTypeDesc = buildTypeDesc;
    }

    @Override
    public String toString() {
        return "BuildingType{" +
                "buildingType_code=" + buildingType_code +
                ", buildingTypeID='" + buildingTypeID + '\'' +
                ", buildTypeDesc='" + buildTypeDesc + '\'' +
                '}';
    }
}
