package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Table(name = "uom")
public class UnitOfMeasurements implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unitOfMeasurement_code")
    private Long unitOfMeasurement_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String unitOfMeasurementID;
    @NotNull
    private String unitOfMeasurementDesc;

    public UnitOfMeasurements() {
    }

    public UnitOfMeasurements(Long unitOfMeasurement_code, String unitOfMeasurementID, String unitOfMeasurementDesc) {
        this.unitOfMeasurement_code = unitOfMeasurement_code;
        this.unitOfMeasurementID = unitOfMeasurementID;
        this.unitOfMeasurementDesc = unitOfMeasurementDesc;
    }

    public Long getUnitOfMeasurement_code() {
        return unitOfMeasurement_code;
    }

    public void setUnitOfMeasurement_code(Long unitOfMeasurement_code) {
        this.unitOfMeasurement_code = unitOfMeasurement_code;
    }

    public String getUnitOfMeasurementID() {
        return unitOfMeasurementID;
    }

    public void setUnitOfMeasurementID(String unitOfMeasurementID) {
        this.unitOfMeasurementID = unitOfMeasurementID;
    }

    public String getUnitOfMeasurementDesc() {
        return unitOfMeasurementDesc;
    }

    public void setUnitOfMeasurementDesc(String unitOfMeasurementDesc) {
        this.unitOfMeasurementDesc = unitOfMeasurementDesc;
    }
}
