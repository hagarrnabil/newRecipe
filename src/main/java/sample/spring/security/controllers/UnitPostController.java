package sample.spring.security.controllers;


import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Project;
import sample.spring.security.models.Unit;
import sample.spring.security.repositories.ProjectRepository;
import sample.spring.security.repositories.UnitRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UnitPostController {


    @Autowired
    private final UnitRepository unitrepository;

    public UnitPostController(UnitRepository unitrepository ) {
        this.unitrepository = unitrepository;
    }

    @GetMapping("/units")
    Iterable<Unit> all() {
        return unitrepository.findAll();
    }

    @RequestMapping(value = "/units/{unit_code}", method = RequestMethod.GET)
    public Optional<Unit> findByIds(@PathVariable @NotNull Long unit_code) {

        return unitrepository.findById(unit_code);
    }

    @PostMapping("/units")
    Unit newUnit(@RequestBody Unit newUnit) {
        return unitrepository.save(newUnit);
    }

    @DeleteMapping("/units/{unit_code}")
    void deleteUnit(@PathVariable Long unit_code) {
        unitrepository.deleteById(unit_code);
    }

    @PutMapping("/units/{unit_code}")
    Unit updateUnit(@RequestBody Unit newUnit, @PathVariable Long unit_code) {

        return unitrepository.findById(unit_code).map(unit -> {
            unit.setAmount(newUnit.getAmount());
            unit.setUnitOfMeasurement(newUnit.getUnitOfMeasurement());
            unit.setDescription(newUnit.getDescription());
            unit.setFloor(newUnit.getFloor());
            unit.setUnitType(newUnit.getUnitType());
            unit.setUnitStatus(newUnit.getUnitStatus());
            unit.setBlockingDate(newUnit.getBlockingDate());
            unit.setBlockingReason(newUnit.getBlockingReason());
            unit.setBuiltUpArea(newUnit.getBuiltUpArea());
            unit.setConditionCode(newUnit.getConditionCode());
            unit.setConditionDescription(newUnit.getConditionDescription());
            unit.setFixture(newUnit.getFixture());
            unit.setConstructionDate(newUnit.getConstructionDate());
            unit.setDestination(newUnit.getDestination());
            unit.setGardenArea(newUnit.getGardenArea());
            unit.setMeasurementsDescription(newUnit.getMeasurementsDescription());
            unit.setMeasurementsID(newUnit.getMeasurementsID());
            unit.setMeasurementsDescription(newUnit.getMeasurementsDescription());
            unit.setMeasurementValue(newUnit.getMeasurementValue());
            unit.setNumberOfRooms(newUnit.getNumberOfRooms());
            unit.setOldNumber(newUnit.getOldNumber());
            unit.setOrientation(newUnit.getOrientation());
            unit.setPrice(newUnit.getPrice());
            unit.setPricePlan(newUnit.getPricePlan());
            unit.setPricingTab(newUnit.getPricingTab());
            unit.setSalesPhase(newUnit.getSalesPhase());
            unit.setToFloor(newUnit.getToFloor());
            unit.setUnitAdditionalPayment(newUnit.getUnitAdditionalPayment());
            unit.setUsageTypeDescription(newUnit.getUsageTypeDescription());
            unit.setView(newUnit.getView());
            unit.setUnit_code(newUnit.getUnit_code());
            unit.setUnitKey(newUnit.getUnitKey());
            unit.setMeasurements(newUnit.getMeasurements());
            return unitrepository.save(newUnit);
        }).orElseGet(() -> {
            newUnit.setUnit_code(unit_code);
            return unitrepository.save(newUnit);
        });
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/units/unitTypeandview")
    @ResponseBody
    public List<Unit> Search(@RequestParam String unitType, @RequestParam String view) {

        return unitrepository.findByUnitTypeAndView(unitType, view);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/units/search")
    @ResponseBody
    public List<Unit> Search(@RequestParam String keyword) {

        return unitrepository.search(keyword);
    }

}
