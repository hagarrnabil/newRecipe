package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Currency;

import java.util.List;

public interface CurrencyRepository extends JpaRepository<Currency,Long> {
    @Query("SELECT c FROM Currency c WHERE CONCAT(c.currency_code, ' ', c.currencyDescription, ' ', c.currencyID) LIKE %?1%")
    public List<Currency> search(String keyword);
}
