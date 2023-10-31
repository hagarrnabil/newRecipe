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

    @RequestMapping(value = "/units/{unitKey}", method = RequestMethod.GET)
    public Optional<Unit> findByIds(@PathVariable @NotNull Long unitKey) {

        return unitrepository.findById(unitKey);
    }

    @PostMapping("/units")
    Unit newUnit(@RequestBody Unit newUnit) {
        return unitrepository.save(newUnit);
    }

    @DeleteMapping("/units/{unitKey}")
    void deleteUnit(@PathVariable Long unitKey) {
        unitrepository.deleteById(unitKey);
    }

    @PutMapping("/units/{unitKey}")
    Unit updateUnit(@RequestBody Unit newUnit, @PathVariable Long unitKey) {

        return unitrepository.findById(unitKey).map(unit -> {
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
            unit.setSapUnitID(newUnit.getSapUnitID());
            unit.setToFloor(newUnit.getToFloor());
            unit.setUnitAdditionalPayment(newUnit.getUnitAdditionalPayment());
            unit.setUsageTypeDescription(newUnit.getUsageTypeDescription());
            unit.setView(newUnit.getView());
            return unitrepository.save(newUnit);
        }).orElseGet(() -> {
            newUnit.setUnitKey(unitKey);
            return unitrepository.save(newUnit);
        });
    }

    //@RequestMapping(method = RequestMethod.GET, value = "units/description")
    //@ResponseBody
   // public List<Unit> search(@RequestParam String description) {

     //   return unitrepository.findByDescription(description);
   // }

    @RequestMapping(method = RequestMethod.GET, value = "/units/unitTypeandview")
    @ResponseBody
    public List<Unit> Search(@RequestParam String unitType, @RequestParam String view) {

        return unitrepository.findByUnitTypeAndView(unitType, view);
    }

}
