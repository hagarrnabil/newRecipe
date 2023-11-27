package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Orientation;

import java.util.List;

public interface OrientationRepository extends JpaRepository<Orientation,Long> {
    @Query("SELECT o FROM Orientation o WHERE CONCAT(o.orientation_code, ' ', o.orientationDescription, ' ', o.orientationID) LIKE %?1%")
    public List<Orientation> search(String keyword);
}
