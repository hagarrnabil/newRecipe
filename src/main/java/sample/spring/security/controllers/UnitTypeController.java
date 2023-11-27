package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Fixture;
import sample.spring.security.models.UnitType;
import sample.spring.security.repositories.UnitTypeRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UnitTypeController {
    @Autowired
    UnitTypeRepository unitTypeRepository;

    public UnitTypeController(UnitTypeRepository unitTypeRepository) {
        this.unitTypeRepository =
                unitTypeRepository;
    }
    @GetMapping("/unitType")
    Iterable<UnitType> all() {
        return unitTypeRepository.findAll();
    }

    @RequestMapping(value = "/unitType/{unitType_code}", method = RequestMethod.GET)
    public Optional<UnitType> findByIds(@PathVariable @NotNull Long unitType_code) {

        return unitTypeRepository.findById(unitType_code);
    }

    @PostMapping("/unitType")
    UnitType newunitType(@RequestBody UnitType newunitType) {
        return unitTypeRepository.save(newunitType);
    }

    @DeleteMapping("/unitType/{unitType_code}")
    void deleteunitType(@PathVariable Long unitType_code) {
        unitTypeRepository.deleteById(unitType_code);
    }

    @PutMapping("/unitType/{unitTypecode}")
    UnitType updateunitType(@RequestBody UnitType newunitType, @PathVariable Long unitType_code) {

        return unitTypeRepository.findById(unitType_code).map(unitType -> {
            unitType.setUnitType_code(newunitType.getUnitType_code());
            unitType.setUnitTypeDescription(newunitType.getUnitTypeDescription());
            unitType.setUnitTypeID(newunitType.getUnitTypeID());
            return unitTypeRepository.save(newunitType);
        }).orElseGet(() -> {
            newunitType.setUnitType_code(unitType_code);
            return unitTypeRepository.save(newunitType);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/unitType/search")
    @ResponseBody
    public List<UnitType> Search(@RequestParam String keyword) {

        return unitTypeRepository.search(keyword);
    }
}
