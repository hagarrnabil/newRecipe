package sample.spring.security.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
@Entity
@Table(name = "unitAreaDetails")
public class UnitAreaDetails implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "area_code")
    private Long area_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String areaID;
    private String area;
    private Integer amount;
//    private String UnitOfMeasurements;
    private Integer noOfRooms;

    public UnitAreaDetails() {
    }

    public UnitAreaDetails(Long area_code, String areaID, String area, Integer amount, Integer noOfRooms) {
        this.area_code = area_code;
        this.areaID = areaID;
        this.area = area;
        this.amount = amount;
        this.noOfRooms = noOfRooms;
    }

    public Long getArea_code() {
        return area_code;
    }

    public void setArea_code(Long area_code) {
        this.area_code = area_code;
    }

    public String getAreaID() {
        return areaID;
    }

    public void setAreaID(String areaID) {
        this.areaID = areaID;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }
}
