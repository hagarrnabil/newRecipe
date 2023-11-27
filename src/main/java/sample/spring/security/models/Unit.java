package sample.spring.security.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="units")
@Data
@NoArgsConstructor(force = true)
@AllArgsConstructor
public class Unit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "unit_code")
    private Long unit_code;

    @Column(unique = true, length = 8, columnDefinition = "char(8)", nullable = false)
    @Length(max = 8)
    private String unitKey;
    @Column(length = 8, columnDefinition = "char(8)")
    @Length(max = 8)
    private Integer oldNumber;
    @NotNull
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date blockingDate;
    private String blockingReason;
    private String salesPhase;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date constructionDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date unitDeliveryDate;
    private String area;
    private Integer areaValue;
    private Integer noOfRooms;
    private Integer price;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validFrom;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "building_code", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonProperty("building_code")
    private Building building;

//    public Unit() {
//
//    }


    public Long getUnit_code() {
        return unit_code;
    }

    public void setUnit_code(Long unit_code) {
        this.unit_code = unit_code;
    }

    public String getUnitKey() {
        return unitKey;
    }

    public void setUnitKey(String unitKey) {
        this.unitKey = unitKey;
    }

    public Integer getOldNumber() {
        return oldNumber;
    }

    public void setOldNumber(Integer oldNumber) {
        this.oldNumber = oldNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBlockingDate() {
        return blockingDate;
    }

    public void setBlockingDate(Date blockingDate) {
        this.blockingDate = blockingDate;
    }

    public String getBlockingReason() {
        return blockingReason;
    }

    public void setBlockingReason(String blockingReason) {
        this.blockingReason = blockingReason;
    }

    public String getSalesPhase() {
        return salesPhase;
    }

    public void setSalesPhase(String salesPhase) {
        this.salesPhase = salesPhase;
    }

    public Date getConstructionDate() {
        return constructionDate;
    }

    public void setConstructionDate(Date constructionDate) {
        this.constructionDate = constructionDate;
    }

    public Date getUnitDeliveryDate() {
        return unitDeliveryDate;
    }

    public void setUnitDeliveryDate(Date unitDeliveryDate) {
        this.unitDeliveryDate = unitDeliveryDate;
    }

    @JsonBackReference
    public Building getBuilding() {
        return building;
    }
    @JsonBackReference
    public void setBuilding(Building building) {
        this.building = building;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getAreaValue() {
        return areaValue;
    }

    public void setAreaValue(Integer areaValue) {
        this.areaValue = areaValue;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unit_code=" + unit_code +
                ", unitKey='" + unitKey + '\'' +
                ", oldNumber=" + oldNumber +
                ", description='" + description + '\'' +
                ", blockingDate=" + blockingDate +
                ", blockingReason='" + blockingReason + '\'' +
                ", salesPhase='" + salesPhase + '\'' +
                ", constructionDate=" + constructionDate +
                ", unitDeliveryDate=" + unitDeliveryDate +
                ", area='" + area + '\'' +
                ", areaValue=" + areaValue +
                ", noOfRooms=" + noOfRooms +
                ", price=" + price +
                ", validFrom=" + validFrom +
                ", building=" + building +
                '}';
    }
}