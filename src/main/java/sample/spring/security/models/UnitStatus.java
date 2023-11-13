package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Table(name = "unitstatus")
public class UnitStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unitStatus_code")
    private Long unitStatus_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String unitStatusID;
    @NotNull
    private String unitStatus;

    public UnitStatus() {
    }

    public UnitStatus(Long unitStatus_code, String unitStatusID, String unitStatus) {
        this.unitStatus_code = unitStatus_code;
        this.unitStatusID = unitStatusID;
        this.unitStatus = unitStatus;
    }

    public Long getUnitStatus_code() {
        return unitStatus_code;
    }

    public void setUnitStatus_code(Long unitStatus_code) {
        this.unitStatus_code = unitStatus_code;
    }

    public String getUnitStatusID() {
        return unitStatusID;
    }

    public void setUnitStatusID(String unitStatusID) {
        this.unitStatusID = unitStatusID;
    }

    public String getUnitStatus() {
        return unitStatus;
    }

    public void setUnitStatus(String unitStatus) {
        this.unitStatus = unitStatus;
    }

    @Override
    public String toString() {
        return "UnitStatus{" +
                "unitStatus_code=" + unitStatus_code +
                ", unitStatusID='" + unitStatusID + '\'' +
                ", unitStatus='" + unitStatus + '\'' +
                '}';
    }
}
