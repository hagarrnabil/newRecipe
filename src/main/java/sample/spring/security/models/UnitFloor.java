package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;

@Entity
@Table(name = "unitfloor")
public class UnitFloor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unitFloor_code")
    private Long unitFloor_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String unitFloorID;
    @NotNull
    private String floor;

    public UnitFloor() {
    }

    public UnitFloor(Long unitFloor_code, String unitFloorID, String floor) {
        this.unitFloor_code = unitFloor_code;
        this.unitFloorID = unitFloorID;
        this.floor = floor;
    }

    public Long getUnitFloor_code() {
        return unitFloor_code;
    }

    public void setUnitFloor_code(Long unitFloor_code) {
        this.unitFloor_code = unitFloor_code;
    }

    public String getUnitFloorID() {
        return unitFloorID;
    }

    public void setUnitFloorID(String unitFloorID) {
        this.unitFloorID = unitFloorID;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "UnitFloor{" +
                "unitFloor_code=" + unitFloor_code +
                ", unitFloorID='" + unitFloorID + '\'' +
                ", floor='" + floor + '\'' +
                '}';
    }
}
