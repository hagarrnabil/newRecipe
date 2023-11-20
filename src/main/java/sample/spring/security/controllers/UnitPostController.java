package sample.spring.security.controllers;


import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Building;
import sample.spring.security.models.Project;
import sample.spring.security.models.Unit;
import sample.spring.security.repositories.BuildingRepository;
import sample.spring.security.repositories.CompanyRepository;
import sample.spring.security.repositories.ProjectRepository;
import sample.spring.security.repositories.UnitRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UnitPostController {

    @Autowired
    private final CompanyRepository companyRepository;
    @Autowired
    private final ProjectRepository projectRepository;
    @Autowired
    private final BuildingRepository buildingRepository;
    @Autowired
    private final UnitRepository unitrepository;


    public UnitPostController(CompanyRepository companyRepository, ProjectRepository projectRepository, BuildingRepository buildingRepository, UnitRepository unitrepository) {
        this.companyRepository = companyRepository;
        this.projectRepository = projectRepository;
        this.buildingRepository = buildingRepository;
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

    @PostMapping("//units")
    Unit newUnit(@RequestBody Unit newUnit) {

        return unitrepository.save(newUnit);
    }


    @DeleteMapping("/units/{unit_code}")
    void deleteUnit(@PathVariable Long unit_code) {
        unitrepository.deleteById(unit_code);
    }

    @PutMapping("//units/{unit_code}")
    Unit updateUnit(@RequestBody Unit newUnit, @PathVariable Long unit_code) {

                    return unitrepository.findById(unit_code).map(unit -> {
                        unit.setAmount(newUnit.getAmount());
                        unit.setUnitType(newUnit.getUnitKey());
                        unit.setUnit_code(newUnit.getUnit_code());
                        unit.setBlockingDate(newUnit.getBlockingDate());
                        unit.setBlockingReason(newUnit.getBlockingReason());
                        unit.setUnitOfMeasurement(newUnit.getUnitOfMeasurement());
                        unit.setUnitAdditionalPayment(newUnit.getUnitAdditionalPayment());
                        unit.setBuiltUpArea(newUnit.getBuiltUpArea());
                        unit.setConditionCode(newUnit.getConditionCode());
                        unit.setConditionDescription(newUnit.getConditionDescription());
                        unit.setToFloor(newUnit.getToFloor());
                        unit.setConstructionDate(newUnit.getConstructionDate());
                        unit.setDestination(newUnit.getDestination());
                        unit.setGardenArea(newUnit.getGardenArea());
                        unit.setMeasurements(newUnit.getMeasurements());
                        unit.setPricingTab(newUnit.getPricingTab());
                        unit.setSalesPhase(newUnit.getSalesPhase());
                        unit.setPricePlan(newUnit.getPricePlan());
                        unit.setOrientation(newUnit.getOrientation());
                        unit.setOldNumber(newUnit.getOldNumber());
                        unit.setNumberOfRooms(newUnit.getNumberOfRooms());
                        unit.setUnitKey(newUnit.getUnitKey());
                        unit.setMeasurementValue(newUnit.getMeasurementValue());
                        unit.setMeasurementsID(newUnit.getMeasurementsID());
                        unit.setMeasurementsDescription(newUnit.getMeasurementsDescription());
                        unit.setFixture(newUnit.getFixture());
                        unit.setDescription(newUnit.getDescription());
                        return unitrepository.save(newUnit);
                    }).orElseGet(() -> {
                        newUnit.setUnit_code(unit_code);
                        return unitrepository.save(newUnit);
                    });
    }


    @RequestMapping(method = RequestMethod.GET, value = "/units/search")
    @ResponseBody
    public List<Unit> Search(@RequestParam String keyword) {

        return unitrepository.search(keyword);
    }

}
