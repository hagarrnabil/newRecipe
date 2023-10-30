package sample.spring.security.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="units")
public class Unit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long unitKey;
    private Long sapUnitID;
    private Integer oldNumber;
    private String description;
    private String unitType;
    private String usageTypeDescription;
    private String unitStatus;
    private String view;
    private Integer floor;
    private Integer toFloor;
    private String blockingReason;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date blockingDate;
    private String fixture;
    private String salesPhase;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date constructionDate;
    private String destination;
    private String orientation;
    private String builtUpArea;
    private String gardenArea;
    private Integer numberOfRooms;
    private Integer measurementValue;
    private Integer measurements;
    private Integer measurementsID;
    private String measurementsDescription;
    private String unitOfMeasurement;
    private Integer pricingTab;
    private String pricePlan;
    private Integer price;
    private Integer unitAdditionalPayment;
    private String conditionCode;
    private String conditionDescription;
    private Integer Amount;

    public Unit(Long unitKey, Long sapUnitID, Integer oldNumber, String description, String unitType, String usageTypeDescription, String unitStatus, String view, Integer floor, Integer toFloor, String blockingReason, Date blockingDate, String fixture, String salesPhase, Date constructionDate, String destination, String orientation, String builtUpArea, String gardenArea, Integer numberOfRooms, Integer measurementValue, Integer measurements, Integer measurementsID, String measurementsDescription, String unitOfMeasurement, Integer pricingTab, String pricePlan, Integer price, Integer unitAdditionalPayment, String conditionCode, String conditionDescription, Integer amount) {
        this.unitKey = unitKey;
        this.sapUnitID = sapUnitID;
        this.oldNumber = oldNumber;
        this.description = description;
        this.unitType = unitType;
        this.usageTypeDescription = usageTypeDescription;
        this.unitStatus = unitStatus;
        this.view = view;
        this.floor = floor;
        this.toFloor = toFloor;
        this.blockingReason = blockingReason;
        this.blockingDate = blockingDate;
        this.fixture = fixture;
        this.salesPhase = salesPhase;
        this.constructionDate = constructionDate;
        this.destination = destination;
        this.orientation = orientation;
        this.builtUpArea = builtUpArea;
        this.gardenArea = gardenArea;
        this.numberOfRooms = numberOfRooms;
        this.measurementValue = measurementValue;
        this.measurements = measurements;
        this.measurementsID = measurementsID;
        this.measurementsDescription = measurementsDescription;
        this.unitOfMeasurement = unitOfMeasurement;
        this.pricingTab = pricingTab;
        this.pricePlan = pricePlan;
        this.price = price;
        this.unitAdditionalPayment = unitAdditionalPayment;
        this.conditionCode = conditionCode;
        this.conditionDescription = conditionDescription;
        Amount = amount;
    }

    public Unit() {

    }

    public Long getUnitKey() {
        return unitKey;
    }

    public void setUnitKey(Long unitKey) {
        this.unitKey = unitKey;
    }

    public Long getSapUnitID() {
        return sapUnitID;
    }

    public void setSapUnitID(Long sapUnitID) {
        this.sapUnitID = sapUnitID;
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

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getUsageTypeDescription() {
        return usageTypeDescription;
    }

    public void setUsageTypeDescription(String usageTypeDescription) {
        this.usageTypeDescription = usageTypeDescription;
    }

    public String getUnitStatus() {
        return unitStatus;
    }

    public void setUnitStatus(String unitStatus) {
        this.unitStatus = unitStatus;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getToFloor() {
        return toFloor;
    }

    public void setToFloor(Integer toFloor) {
        this.toFloor = toFloor;
    }

    public String getBlockingReason() {
        return blockingReason;
    }

    public void setBlockingReason(String blockingReason) {
        this.blockingReason = blockingReason;
    }

    public Date getBlockingDate() {
        return blockingDate;
    }

    public void setBlockingDate(Date blockingDate) {
        this.blockingDate = blockingDate;
    }

    public String getFixture() {
        return fixture;
    }

    public void setFixture(String fixture) {
        this.fixture = fixture;
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getBuiltUpArea() {
        return builtUpArea;
    }

    public void setBuiltUpArea(String builtUpArea) {
        this.builtUpArea = builtUpArea;
    }

    public String getGardenArea() {
        return gardenArea;
    }

    public void setGardenArea(String gardenArea) {
        this.gardenArea = gardenArea;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public Integer getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(Integer measurementValue) {
        this.measurementValue = measurementValue;
    }

    public Integer getMeasurements() {
        return measurements;
    }

    public void setMeasurements(Integer measurements) {
        this.measurements = measurements;
    }

    public Integer getMeasurementsID() {
        return measurementsID;
    }

    public void setMeasurementsID(Integer measurementsID) {
        this.measurementsID = measurementsID;
    }

    public String getMeasurementsDescription() {
        return measurementsDescription;
    }

    public void setMeasurementsDescription(String measurementsDescription) {
        this.measurementsDescription = measurementsDescription;
    }

    public String getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void setUnitOfMeasurement(String unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public Integer getPricingTab() {
        return pricingTab;
    }

    public void setPricingTab(Integer pricingTab) {
        this.pricingTab = pricingTab;
    }

    public String getPricePlan() {
        return pricePlan;
    }

    public void setPricePlan(String pricePlan) {
        this.pricePlan = pricePlan;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getUnitAdditionalPayment() {
        return unitAdditionalPayment;
    }

    public void setUnitAdditionalPayment(Integer unitAdditionalPayment) {
        this.unitAdditionalPayment = unitAdditionalPayment;
    }

    public String getConditionCode() {
        return conditionCode;
    }

    public void setConditionCode(String conditionCode) {
        this.conditionCode = conditionCode;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public void setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitKey=" + unitKey +
                ", sapUnitID=" + sapUnitID +
                ", oldNumber=" + oldNumber +
                ", description='" + description + '\'' +
                ", unitType='" + unitType + '\'' +
                ", usageTypeDescription='" + usageTypeDescription + '\'' +
                ", unitStatus='" + unitStatus + '\'' +
                ", view='" + view + '\'' +
                ", floor=" + floor +
                ", toFloor=" + toFloor +
                ", blockingReason='" + blockingReason + '\'' +
                ", blockingDate=" + blockingDate +
                ", fixture='" + fixture + '\'' +
                ", salesPhase='" + salesPhase + '\'' +
                ", constructionDate=" + constructionDate +
                ", destination='" + destination + '\'' +
                ", orientation='" + orientation + '\'' +
                ", builtUpArea='" + builtUpArea + '\'' +
                ", gardenArea='" + gardenArea + '\'' +
                ", numberOfRooms=" + numberOfRooms +
                ", measurementValue=" + measurementValue +
                ", measurements=" + measurements +
                ", measurementsID=" + measurementsID +
                ", measurementsDescription='" + measurementsDescription + '\'' +
                ", unitOfMeasurement='" + unitOfMeasurement + '\'' +
                ", pricingTab=" + pricingTab +
                ", pricePlan='" + pricePlan + '\'' +
                ", price=" + price +
                ", unitAdditionalPayment=" + unitAdditionalPayment +
                ", conditionCode='" + conditionCode + '\'' +
                ", conditionDescription='" + conditionDescription + '\'' +
                ", Amount=" + Amount +
                '}';
    }
}