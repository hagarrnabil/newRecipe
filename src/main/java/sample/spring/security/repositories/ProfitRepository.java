package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Profit;

import java.util.List;

public interface ProfitRepository extends JpaRepository<Profit,Long> {
    @Query("SELECT p FROM Profit p WHERE CONCAT(p.profit_code, ' ', p.profitDescription, ' ', p.profitID) LIKE %?1%")
    public List<Profit> search(String keyword);
}
