package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sample.spring.security.models.Project;

import java.util.List;

public interface PaymentPlan extends JpaRepository<sample.spring.security.models.PaymentPlan,Long> {
  //  List<sample.spring.security.models.PaymentPlan> findByPhase(String phase);
    List<sample.spring.security.models.PaymentPlan> findByPaymentPlanDetailsAndPlanStatus(String paymentPlanDetails, String planStatus);
}
