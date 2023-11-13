package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Cities;
import sample.spring.security.models.UnitFloor;
import sample.spring.security.repositories.UnitFloorRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UnitFloorController {
    @Autowired
    private final UnitFloorRepository unitFloorRepository;

    public UnitFloorController(UnitFloorRepository unitFloorRepository) {
        this.unitFloorRepository = unitFloorRepository;
    }
    @GetMapping("/unitfloor")
    Iterable<UnitFloor> all() {
        return unitFloorRepository.findAll();
    }

    @RequestMapping(value = "/unitfloor/{unitFloor_code}", method = RequestMethod.GET)
    public Optional<UnitFloor> findByIds(@PathVariable @NotNull Long unitFloor_code) {

        return unitFloorRepository.findById(unitFloor_code);
    }

    @PostMapping("/unitfloor")
    UnitFloor newUnitFloor(@RequestBody UnitFloor newUnitFloor) {
        return unitFloorRepository.save(newUnitFloor);
    }

    @DeleteMapping("/unitfloor/{unitFloor_code}")
    void deleteUnitFloor(@PathVariable Long unitFloor_code) {
        unitFloorRepository.deleteById(unitFloor_code);
    }

    @PutMapping("/unitfloor/{unitFloor_code}")
    UnitFloor updateUnitFloor(@RequestBody UnitFloor newUnitFloor, @PathVariable Long unitFloor_code) {

        return unitFloorRepository.findById(unitFloor_code).map(unitFloor -> {
            unitFloor.setUnitFloor_code(newUnitFloor.getUnitFloor_code());
            unitFloor.setUnitFloorID(newUnitFloor.getUnitFloorID());
            unitFloor.setFloor(newUnitFloor.getFloor());
            return unitFloorRepository.save(newUnitFloor);
        }).orElseGet(() -> {
            newUnitFloor.setUnitFloor_code(unitFloor_code);
            return unitFloorRepository.save(newUnitFloor);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/unitfloor/search")
    @ResponseBody
    public List<UnitFloor> Search(@RequestParam String keyword) {

        return unitFloorRepository.search(keyword);
    }
}
