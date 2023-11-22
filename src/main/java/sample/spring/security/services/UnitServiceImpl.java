package sample.spring.security.services;

import org.springframework.stereotype.Service;
import sample.spring.security.models.Unit;
import sample.spring.security.repositories.UnitRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UnitServiceImpl implements UnitService{
    private final UnitRepository unitRepository;

    public UnitServiceImpl(UnitRepository unitRepository) {
        super();
        this.unitRepository = unitRepository;
    }

    @Override
    public List<Unit> getAllUnits() {
        return unitRepository.findAll();
    }

    @Override
    public Unit createUnit(Unit unit) {
        return unitRepository.save(unit);
    }

    @Override
    public Unit updateUnit(long unit_code, Unit unit) {
        return unitRepository.findById(unit_code).map(unit1 -> {
            unit1.setAmount(unit.getAmount());
            unit1.setBlockingDate(unit.getBlockingDate());
            unit1.setUnitType(unit.getUnitType());
            unit1.setUnit_code(unit.getUnit_code());
            unit1.setUnitKey(unit1.getUnitKey());
            unit1.setBlockingReason(unit.getBlockingReason());
            unit1.setBuiltUpArea(unit.getBuiltUpArea());
            unit1.setConditionCode(unit.getConditionCode());
            unit1.setConditionDescription(unit.getConditionDescription());
            unit1.setConstructionDate(unit.getConstructionDate());
            unit1.setDescription(unit.getDescription());
            unit1.setDestination(unit.getDestination());
            unit1.setFixture(unit.getFixture());
            unit1.setGardenArea(unit.getGardenArea());
            unit1.setMeasurements(unit.getMeasurements());
            unit1.setMeasurementsDescription(unit.getMeasurementsDescription());
            unit1.setMeasurementsID(unit1.getMeasurementsID());
            unit1.setMeasurementValue(unit.getMeasurementValue());
            unit1.setNumberOfRooms(unit.getNumberOfRooms());
            unit1.setOldNumber(unit.getOldNumber());
            unit1.setOrientation(unit.getOrientation());
            unit1.setPrice(unit.getPrice());
            unit1.setPricePlan(unit.getPricePlan());
            unit1.setPricingTab(unit.getPricingTab());
            unit1.setSalesPhase(unit.getSalesPhase());
            unit1.setToFloor(unit.getToFloor());
            unit1.setUnitAdditionalPayment(unit.getUnitAdditionalPayment());
            unit1.setUnitOfMeasurement(unit.getUnitOfMeasurement());
            return unitRepository.save(unit);
        }).orElseGet(() -> {
            unit.setUnit_code(unit_code);
            return unitRepository.save(unit);
        });
    }

    @Override
    public void deleteUnit(long unit_code) {
        unitRepository.deleteById(unit_code);
    }

    @Override
    public Optional<Unit> getUnitById(long unit_code) {
        return unitRepository.findById(unit_code);
    }
}
