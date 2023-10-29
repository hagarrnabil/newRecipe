package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Project;
import sample.spring.security.repositories.PaymentPlan;

import java.util.Optional;
@RestController
public class PaymentPlanController {

    @Autowired
    private final PaymentPlan paymentplan;

    public PaymentPlanController(PaymentPlan paymentplan) {
        this.paymentplan = paymentplan;
    }

    @GetMapping("/paymentplans")
    Iterable<sample.spring.security.models.PaymentPlan> all() {
        return paymentplan.findAll();
    }

    @RequestMapping(value = "/paymentplans/{paymentPlanCode}", method = RequestMethod.GET)
    public Optional<sample.spring.security.models.PaymentPlan> findByIds(@PathVariable @NotNull Long paymentPlanCode) {

        return paymentplan.findById(paymentPlanCode);
    }

    @PostMapping("/paymentplans")
    sample.spring.security.models.PaymentPlan newPaymentPlans(@RequestBody sample.spring.security.models.PaymentPlan newPaymentPlans) {
        return paymentplan.save(newPaymentPlans);
    }

    @DeleteMapping("/paymentplans/{paymentPlanCode}")
    void deletePaymentPlans(@PathVariable Long paymentPlanCode) {
        paymentplan.deleteById(paymentPlanCode);
    }

    @PutMapping("/paymentplans/{paymentPlanCode}")
    sample.spring.security.models.PaymentPlan updatePaymentPlans
            (@RequestBody sample.spring.security.models.PaymentPlan newPaymentPlans,
             @PathVariable Long paymentPlanCode) {

        return paymentplan.findById(paymentPlanCode).map(paymentPlan -> {
            paymentPlan.setPaymentPlanCode(newPaymentPlans.getPaymentPlanCode());
            paymentPlan.setPaymentPlanDescription(newPaymentPlans.getPaymentPlanDescription());
            paymentPlan.setConditionGroup(newPaymentPlans.getConditionGroup());
            paymentPlan.setAssignedPricePlan(newPaymentPlans.getAssignedPricePlan());
            paymentPlan.setNoOfYears(newPaymentPlans.getNoOfYears());
            paymentPlan.setValidFrom(newPaymentPlans.getValidFrom());
            paymentPlan.setValidTo(newPaymentPlans.getValidTo());
            paymentPlan.setMaintenanceNumberOfMonth(newPaymentPlans.getMaintenanceNumberOfMonth());
            paymentPlan.setInstallmentCalculationMethod(newPaymentPlans.getInstallmentCalculationMethod());
            paymentPlan.setPhase(newPaymentPlans.getPhase());
            paymentPlan.setPlanStatus(newPaymentPlans.getPlanStatus());
            paymentPlan.setApprovalStatus(newPaymentPlans.getApprovalStatus());
            paymentPlan.setAssignedProjectsTab(newPaymentPlans.getAssignedProjectsTab());
            paymentPlan.setPaymentPlanDetails(newPaymentPlans.getPaymentPlanDetails());
            paymentPlan.setConditionType(newPaymentPlans.getConditionType());
            paymentPlan.setConditionPercentage(newPaymentPlans.getConditionPercentage());
            paymentPlan.setConditionBasePrice(newPaymentPlans.getConditionBasePrice());
            paymentPlan.setCalculationMethod(newPaymentPlans.getCalculationMethod());
            paymentPlan.setFrequency(newPaymentPlans.getFrequency());
            paymentPlan.setDueOnInMonth(newPaymentPlans.getDueOnInMonth());
            paymentPlan.setNoOfInstallments(newPaymentPlans.getNoOfInstallments());
            return paymentplan.save(newPaymentPlans);
        }).orElseGet(() -> {
            newPaymentPlans.setPaymentPlanCode(paymentPlanCode);
            return paymentplan.save(newPaymentPlans);
        });
    }



}


