package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PaymentPlan extends JpaRepository<sample.spring.security.models.PaymentPlan,Long> {
    List<sample.spring.security.models.PaymentPlan> findByPaymentPlanDetailsAndPlanStatus(String paymentPlanDetails, String planStatus);
    @Query("SELECT p FROM PaymentPlan p WHERE CONCAT(p.validFrom, ' ', p.approvalStatus, ' ', p.assignedPricePlan, ' '," +
          " p.assignedProjectsTab, ' ', p.calculationMethod, ' ', p.conditionBasePrice, ' ', p.conditionGroup" +
            ", ' ', p.conditionPercentage, ' ',p.dueOnInMonth,' ', p.conditionType, ' ', p.frequency, ' '," +
            "p.installmentCalculationMethod,' ' ,p.maintenanceNumberOfMonth, ' ',p.noOfInstallments, ' '," +
            "p.noOfYears,' ',p.paymentPlanCode,' ',p.paymentPlanDescription,' ' ,p.paymentPlanDetails, ' '," +
            "p.Phase, ' ',p.planStatus,' ',p.validTo) LIKE %?1%")
    public List<sample.spring.security.models.PaymentPlan> search(String keyword);
}
