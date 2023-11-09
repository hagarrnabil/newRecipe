package sample.spring.security.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Range;

import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name="paymentPlans")
public class PaymentPlan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "payment_code")
    private Long payment_code;
    @NotNull
    @Column(unique = true)
    private char paymentPlanCode;
    @NotNull
    private String paymentPlanDescription;
    private String conditionGroup;
    private String assignedPricePlan;
    @NotNull
    @Range(min = 1)
    @JsonProperty("no_of_years")
    private Integer noOfYears;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validFrom;
    @JsonFormat(pattern="yyyy-MM-dd")
    private Date validTo;
    private Integer maintenanceNumberOfMonth;
    private String installmentCalculationMethod;
    private String Phase;
    private String planStatus;
    private String approvalStatus;
    private String assignedProjectsTab;
    private String paymentPlanDetails;
    private String conditionType;
    private String conditionPercentage;
    private Integer conditionBasePrice;
    private String calculationMethod;
    private String frequency;
    private String dueOnInMonth;
    private Integer noOfInstallments;

    public PaymentPlan(Long payment_code, char paymentPlanCode, String paymentPlanDescription, String conditionGroup, String assignedPricePlan, Integer noOfYears, Date validFrom, Date validTo, Integer maintenanceNumberOfMonth, String installmentCalculationMethod, String phase, String planStatus, String approvalStatus, String assignedProjectsTab, String paymentPlanDetails, String conditionType, String conditionPercentage, Integer conditionBasePrice, String calculationMethod, String frequency, String dueOnInMonth, Integer noOfInstallments) {
        this.payment_code = payment_code;
        this.paymentPlanCode = paymentPlanCode;
        this.paymentPlanDescription = paymentPlanDescription;
        this.conditionGroup = conditionGroup;
        this.assignedPricePlan = assignedPricePlan;
        this.noOfYears = noOfYears;
        this.validFrom = validFrom;
        this.validTo = validTo;
        this.maintenanceNumberOfMonth = maintenanceNumberOfMonth;
        this.installmentCalculationMethod = installmentCalculationMethod;
        Phase = phase;
        this.planStatus = planStatus;
        this.approvalStatus = approvalStatus;
        this.assignedProjectsTab = assignedProjectsTab;
        this.paymentPlanDetails = paymentPlanDetails;
        this.conditionType = conditionType;
        this.conditionPercentage = conditionPercentage;
        this.conditionBasePrice = conditionBasePrice;
        this.calculationMethod = calculationMethod;
        this.frequency = frequency;
        this.dueOnInMonth = dueOnInMonth;
        this.noOfInstallments = noOfInstallments;
    }

    public PaymentPlan() {

    }

    public Long getPayment_code() {
        return payment_code;
    }

    public void setPayment_code(Long payment_code) {
        this.payment_code = payment_code;
    }

    public char getPaymentPlanCode() {
        return paymentPlanCode;
    }

    public void setPaymentPlanCode(char paymentPlanCode) {
        this.paymentPlanCode = paymentPlanCode;
    }

    public String getPaymentPlanDescription() {
        return paymentPlanDescription;
    }

    public void setPaymentPlanDescription(String paymentPlanDescription) {
        this.paymentPlanDescription = paymentPlanDescription;
    }

    public String getConditionGroup() {
        return conditionGroup;
    }

    public void setConditionGroup(String conditionGroup) {
        this.conditionGroup = conditionGroup;
    }

    public String getAssignedPricePlan() {
        return assignedPricePlan;
    }

    public void setAssignedPricePlan(String assignedPricePlan) {
        this.assignedPricePlan = assignedPricePlan;
    }

    public Integer getNoOfYears() {
        return noOfYears;
    }

    public void setNoOfYears(Integer noOfYears) {
        this.noOfYears = noOfYears;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public Integer getMaintenanceNumberOfMonth() {
        return maintenanceNumberOfMonth;
    }

    public void setMaintenanceNumberOfMonth(Integer maintenanceNumberOfMonth) {
        this.maintenanceNumberOfMonth = maintenanceNumberOfMonth;
    }

    public String getInstallmentCalculationMethod() {
        return installmentCalculationMethod;
    }

    public void setInstallmentCalculationMethod(String installmentCalculationMethod) {
        this.installmentCalculationMethod = installmentCalculationMethod;
    }

    public String getPhase() {
        return Phase;
    }

    public void setPhase(String phase) {
        Phase = phase;
    }

    public String getPlanStatus() {
        return planStatus;
    }

    public void setPlanStatus(String planStatus) {
        this.planStatus = planStatus;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getAssignedProjectsTab() {
        return assignedProjectsTab;
    }

    public void setAssignedProjectsTab(String assignedProjectsTab) {
        this.assignedProjectsTab = assignedProjectsTab;
    }

    public String getPaymentPlanDetails() {
        return paymentPlanDetails;
    }

    public void setPaymentPlanDetails(String paymentPlanDetails) {
        this.paymentPlanDetails = paymentPlanDetails;
    }

    public String getConditionType() {
        return conditionType;
    }

    public void setConditionType(String conditionType) {
        this.conditionType = conditionType;
    }

    public String getConditionPercentage() {
        return conditionPercentage;
    }

    public void setConditionPercentage(String conditionPercentage) {
        this.conditionPercentage = conditionPercentage;
    }

    public Integer getConditionBasePrice() {
        return conditionBasePrice;
    }

    public void setConditionBasePrice(Integer conditionBasePrice) {
        this.conditionBasePrice = conditionBasePrice;
    }

    public String getCalculationMethod() {
        return calculationMethod;
    }

    public void setCalculationMethod(String calculationMethod) {
        this.calculationMethod = calculationMethod;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getDueOnInMonth() {
        return dueOnInMonth;
    }

    public void setDueOnInMonth(String dueOnInMonth) {
        this.dueOnInMonth = dueOnInMonth;
    }

    public Integer getNoOfInstallments() {
        return noOfInstallments;
    }

    public void setNoOfInstallments(Integer noOfInstallments) {
        this.noOfInstallments = noOfInstallments;
    }

    @Override
    public String toString() {
        return "PaymentPlan{" +
                "payment_code=" + payment_code +
                ", paymentPlanCode=" + paymentPlanCode +
                ", paymentPlanDescription='" + paymentPlanDescription + '\'' +
                ", conditionGroup='" + conditionGroup + '\'' +
                ", assignedPricePlan='" + assignedPricePlan + '\'' +
                ", noOfYears=" + noOfYears +
                ", validFrom=" + validFrom +
                ", validTo=" + validTo +
                ", maintenanceNumberOfMonth=" + maintenanceNumberOfMonth +
                ", installmentCalculationMethod='" + installmentCalculationMethod + '\'' +
                ", Phase='" + Phase + '\'' +
                ", planStatus='" + planStatus + '\'' +
                ", approvalStatus='" + approvalStatus + '\'' +
                ", assignedProjectsTab='" + assignedProjectsTab + '\'' +
                ", paymentPlanDetails='" + paymentPlanDetails + '\'' +
                ", conditionType='" + conditionType + '\'' +
                ", conditionPercentage='" + conditionPercentage + '\'' +
                ", conditionBasePrice=" + conditionBasePrice +
                ", calculationMethod='" + calculationMethod + '\'' +
                ", frequency='" + frequency + '\'' +
                ", dueOnInMonth='" + dueOnInMonth + '\'' +
                ", noOfInstallments=" + noOfInstallments +
                '}';
    }
}