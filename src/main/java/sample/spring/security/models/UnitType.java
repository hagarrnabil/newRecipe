package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Table(name="unitType")
public class UnitType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unitType_code")
    private Long unitType_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String unitTypeID;
    @NotNull
    private String unitTypeDescription;


    public UnitType() {
    }

    public UnitType(Long unitType_code, String unitTypeID, String unitTypeDescription) {
        this.unitType_code = unitType_code;
        this.unitTypeID = unitTypeID;
        this.unitTypeDescription = unitTypeDescription;
    }

    public Long getUnitType_code() {
        return unitType_code;
    }

    public void setUnitType_code(Long unitType_code) {
        this.unitType_code = unitType_code;
    }

    public String getUnitTypeID() {
        return unitTypeID;
    }

    public void setUnitTypeID(String unitTypeID) {
        this.unitTypeID = unitTypeID;
    }

    public String getUnitTypeDescription() {
        return unitTypeDescription;
    }

    public void setUnitTypeDescription(String unitTypeDescription) {
        this.unitTypeDescription = unitTypeDescription;
    }
}
