package sample.spring.security.services;



import sample.spring.security.models.Unit;

import java.util.List;
import java.util.Optional;

public interface UnitService {
    List<Unit> getAllUnits();

    Unit createUnit(Unit unit);

    Unit updateUnit(long unit_code, Unit unit);

    void deleteUnit(long unit_code);

    Optional<Unit> getUnitById(long unit_code);
}
