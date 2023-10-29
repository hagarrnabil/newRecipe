package sample.spring.security.repositories;

import org.springframework.data.repository.CrudRepository;

public interface PaymentPlan extends CrudRepository<sample.spring.security.models.PaymentPlan,Long> {
}
