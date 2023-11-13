package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Cities;
import sample.spring.security.models.UnitStatus;
import sample.spring.security.repositories.UnitStatusRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UnitStatusController {
    @Autowired
    private final UnitStatusRepository unitStatusRepository;

    public UnitStatusController(UnitStatusRepository unitStatusRepository) {
        this.unitStatusRepository = unitStatusRepository;
    }
    @GetMapping("/unitstatus")
    Iterable<UnitStatus> all() {
        return unitStatusRepository.findAll();
    }

    @RequestMapping(value = "/unitstatus/{unitStatus_code}", method = RequestMethod.GET)
    public Optional<UnitStatus> findByIds(@PathVariable @NotNull Long unitStatus_code) {

        return unitStatusRepository.findById(unitStatus_code);
    }

    @PostMapping("/unitstatus")
    UnitStatus newUnitStatus(@RequestBody UnitStatus newUnitStatus) {
        return unitStatusRepository.save(newUnitStatus);
    }

    @DeleteMapping("/unitstatus/{unitStatus_code}")
    void deleteUnitStatus(@PathVariable Long unitStatus_code) {
        unitStatusRepository.deleteById(unitStatus_code);
    }

    @PutMapping("/unitstatus/{unitStatus_code}")
    UnitStatus updateUnitStatus(@RequestBody UnitStatus newUnitStatus, @PathVariable Long unitStatus_code) {

        return unitStatusRepository.findById(unitStatus_code).map(unitStatus -> {
            unitStatus.setUnitStatus(newUnitStatus.getUnitStatus());
            unitStatus.setUnitStatus_code(newUnitStatus.getUnitStatus_code());
            unitStatus.setUnitStatusID(newUnitStatus.getUnitStatusID());
            return unitStatusRepository.save(newUnitStatus);
        }).orElseGet(() -> {
            newUnitStatus.setUnitStatus_code(unitStatus_code);
            return unitStatusRepository.save(newUnitStatus);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/unitstatus/search")
    @ResponseBody
    public List<UnitStatus> Search(@RequestParam String keyword) {

        return unitStatusRepository.search(keyword);
    }
}
