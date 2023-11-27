package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Cities;
import sample.spring.security.models.MoC;

import java.util.List;

public interface MoCRepository extends JpaRepository<MoC,Long> {
    @Query("SELECT m FROM MoC m WHERE CONCAT(m.methodOfCalc_code, ' ',m.methodOfCalcDescription, ' ',m.methodOfCalcID) LIKE %?1%")
    public List<MoC> search(String keyword);
}
