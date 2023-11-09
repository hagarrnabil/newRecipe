package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Project;
import sample.spring.security.models.Unit;
import sample.spring.security.repositories.PaymentPlan;

import java.util.List;
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

    @RequestMapping(value = "/paymentplans/{payment_code}", method = RequestMethod.GET)
    public Optional<sample.spring.security.models.PaymentPlan> findByIds(@PathVariable @NotNull Long payment_code) {

        return paymentplan.findById(payment_code);
    }

    @PostMapping("/paymentplans")
    sample.spring.security.models.PaymentPlan newPaymentPlans(@RequestBody sample.spring.security.models.PaymentPlan newPaymentPlans) {
        return paymentplan.save(newPaymentPlans);
    }

    @DeleteMapping("/paymentplans/{payment_code}")
    void deletePaymentPlans(@PathVariable Long payment_code) {
        paymentplan.deleteById(payment_code);
    }

    @PutMapping("/paymentplans/{payment_code}")
    sample.spring.security.models.PaymentPlan updatePaymentPlans
            (@RequestBody sample.spring.security.models.PaymentPlan newPaymentPlans,
             @PathVariable Long payment_code) {

        return paymentplan.findById(payment_code).map(paymentPlan -> {
            paymentPlan.setPayment_code(newPaymentPlans.getPayment_code());
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
            newPaymentPlans.setPayment_code(payment_code);
            return paymentplan.save(newPaymentPlans);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/paymentplans/paymentPlanDetailsandplanStatus")
    @ResponseBody
    public List<sample.spring.security.models.PaymentPlan> Search(
            @RequestParam String paymentPlanDetails, @RequestParam String planStatus) {

        return paymentplan.findByPaymentPlanDetailsAndPlanStatus(paymentPlanDetails, planStatus);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/paymentplans/search")
    @ResponseBody
    public List<sample.spring.security.models.PaymentPlan> Search(
            @RequestParam String keyword) {

        return paymentplan.search(keyword);
    }

}


