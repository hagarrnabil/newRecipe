package sample.spring.security.DTOModels;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class UnitDTO {
    private Long unit_code;
    private String unitKey;
    private Integer oldNumber;
    private String description;
    private String unitType;
    private Integer toFloor;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date blockingDate;
    private String blockingReason;
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
    private Long building_code;

//    public UnitDTO(Long unit_code, String unitKey, Integer oldNumber, String description, String unitType, Integer toFloor, Date blockingDate, String blockingReason, String fixture, String salesPhase, Date constructionDate, String destination, String orientation, String builtUpArea, String gardenArea, Integer numberOfRooms, Integer measurementValue, Integer measurements, Integer measurementsID, String measurementsDescription, String unitOfMeasurement, Integer pricingTab, String pricePlan, Integer price, Integer unitAdditionalPayment, String conditionCode, String conditionDescription, Integer amount, Long building_code) {
//        this.unit_code = unit_code;
//        this.unitKey = unitKey;
//        this.oldNumber = oldNumber;
//        this.description = description;
//        this.unitType = unitType;
//        this.toFloor = toFloor;
//        this.blockingDate = blockingDate;
//        this.blockingReason = blockingReason;
//        this.fixture = fixture;
//        this.salesPhase = salesPhase;
//        this.constructionDate = constructionDate;
//        this.destination = destination;
//        this.orientation = orientation;
//        this.builtUpArea = builtUpArea;
//        this.gardenArea = gardenArea;
//        this.numberOfRooms = numberOfRooms;
//        this.measurementValue = measurementValue;
//        this.measurements = measurements;
//        this.measurementsID = measurementsID;
//        this.measurementsDescription = measurementsDescription;
//        this.unitOfMeasurement = unitOfMeasurement;
//        this.pricingTab = pricingTab;
//        this.pricePlan = pricePlan;
//        this.price = price;
//        this.unitAdditionalPayment = unitAdditionalPayment;
//        this.conditionCode = conditionCode;
//        this.conditionDescription = conditionDescription;
//        Amount = amount;
//        this.building_code = building_code;
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

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public Integer getToFloor() {
        return toFloor;
    }

    public void setToFloor(Integer toFloor) {
        this.toFloor = toFloor;
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

    public Long getBuilding_code() {
        return building_code;
    }

    public void setBuilding_code(Long building_code) {
        this.building_code = building_code;
    }
}
