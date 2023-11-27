package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Cities;
import sample.spring.security.models.PriceType;

import java.util.List;

public interface PriceTypeRepository extends JpaRepository<PriceType,Long> {
    @Query("SELECT p FROM PriceType p WHERE CONCAT(p.priceType_code, ' ',p.priceTypeDescription, ' ',p.priceTypeID) LIKE %?1%")
    public List<PriceType> search(String keyword);
}
