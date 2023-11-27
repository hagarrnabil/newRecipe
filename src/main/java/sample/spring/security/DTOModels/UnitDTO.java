package sample.spring.security.DTOModels;


import lombok.Data;

import java.util.Date;

@Data
public class UnitDTO {
    private Long unit_code;
    private String unitKey;
    private Integer oldNumber;
    private String description;
    private Date blockingDate;
    private String blockingReason;
    private String salesPhase;
    private Date constructionDate;
    private Date unitDeliveryDate;
    private String area;
    private Integer areaValue;
    private Integer noOfRooms;
    private Integer price;
    private Date validFrom;
    private Long building_code;
    private String unitTypeDescription;

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

    public Long getBuilding_code() {
        return building_code;
    }

    public void setBuilding_code(Long building_code) {
        this.building_code = building_code;
    }
}
