package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.UnitView;

import java.util.List;

public interface UnitViewRepository extends JpaRepository<UnitView,Long> {
    @Query("SELECT u FROM UnitView u WHERE CONCAT(u.unitView_code, ' ', u.unitViewID, ' ', u.view) LIKE %?1%")
    public List<UnitView> search(String keyword);
}
