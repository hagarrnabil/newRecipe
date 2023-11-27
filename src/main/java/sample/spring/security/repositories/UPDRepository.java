package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Cities;
import sample.spring.security.models.UnitPaymentDetails;

import java.util.List;

public interface UPDRepository extends JpaRepository<UnitPaymentDetails,Long> {
    @Query("SELECT u FROM UnitPaymentDetails u WHERE CONCAT(u.amount, ' ', u.payment_code, ' ',u.paymentID, ' ',u.validFrom) LIKE %?1%")
    public List<UnitPaymentDetails> search(String keyword);
}
