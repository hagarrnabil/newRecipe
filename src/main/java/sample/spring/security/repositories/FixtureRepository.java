package sample.spring.security.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sample.spring.security.models.Fixture;

import java.util.List;

public interface FixtureRepository extends JpaRepository<Fixture,Long> {
    @Query ("SELECT f FROM Fixture f WHERE CONCAT(f.fixture_code, ' ',f.fixtureDescription, ' ', f.fixtureID) LIKE %?1%")
    public List<Fixture> search(String keyword);
}
