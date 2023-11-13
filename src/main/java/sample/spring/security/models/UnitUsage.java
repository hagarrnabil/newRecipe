package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Table(name = "unitusage")
public class UnitUsage implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unitUsage_code")
    private Long unitUsage_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String unitUsageID;
    @NotNull
    private String usageTypeDescription;

    public UnitUsage() {
    }

    public UnitUsage(Long unitUsage_code, String unitUsageID, String usageTypeDescription) {
        this.unitUsage_code = unitUsage_code;
        this.unitUsageID = unitUsageID;
        this.usageTypeDescription = usageTypeDescription;
    }

    public Long getUnitUsage_code() {
        return unitUsage_code;
    }

    public void setUnitUsage_code(Long unitUsage_code) {
        this.unitUsage_code = unitUsage_code;
    }

    public String getUnitUsageID() {
        return unitUsageID;
    }

    public void setUnitUsageID(String unitUsageID) {
        this.unitUsageID = unitUsageID;
    }

    public String getUsageTypeDescription() {
        return usageTypeDescription;
    }

    public void setUsageTypeDescription(String usageTypeDescription) {
        this.usageTypeDescription = usageTypeDescription;
    }

    @Override
    public String toString() {
        return "UnitUsage{" +
                "unitUsage_code=" + unitUsage_code +
                ", unitUsageID='" + unitUsageID + '\'' +
                ", usageTypeDescription='" + usageTypeDescription + '\'' +
                '}';
    }
}
