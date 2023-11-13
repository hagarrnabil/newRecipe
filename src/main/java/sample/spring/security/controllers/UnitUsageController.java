package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Cities;
import sample.spring.security.models.UnitUsage;
import sample.spring.security.repositories.UnitUsageRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UnitUsageController {
    @Autowired
    private final UnitUsageRepository unitUsageRepository;

    public UnitUsageController(UnitUsageRepository unitUsageRepository) {
        this.unitUsageRepository = unitUsageRepository;
    }
    @GetMapping("/unitusage")
    Iterable<UnitUsage> all() {
        return unitUsageRepository.findAll();
    }

    @RequestMapping(value = "/unitusage/{unitUsage_code}", method = RequestMethod.GET)
    public Optional<UnitUsage> findByIds(@PathVariable @NotNull Long unitUsage_code) {

        return unitUsageRepository.findById(unitUsage_code);
    }

    @PostMapping("/unitusage")
    UnitUsage newUnitUsage(@RequestBody UnitUsage newUnitUsage) {
        return unitUsageRepository.save(newUnitUsage);
    }

    @DeleteMapping("/unitusage/{unitUsage_code}")
    void deleteUnitUsage(@PathVariable Long unitUsage_code) {
        unitUsageRepository.deleteById(unitUsage_code);
    }

    @PutMapping("/unitusage/{unitUsage_code}")
    UnitUsage updateUnitUsage(@RequestBody UnitUsage newUnitUsage, @PathVariable Long unitUsage_code) {

        return unitUsageRepository.findById(unitUsage_code).map(unitUsage -> {
            unitUsage.setUsageTypeDescription(newUnitUsage.getUsageTypeDescription());
            unitUsage.setUnitUsage_code(newUnitUsage.getUnitUsage_code());
            unitUsage.setUnitUsageID(newUnitUsage.getUnitUsageID());
            return unitUsageRepository.save(newUnitUsage);
        }).orElseGet(() -> {
            newUnitUsage.setUnitUsage_code(unitUsage_code);
            return unitUsageRepository.save(newUnitUsage);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/unitusage/search")
    @ResponseBody
    public List<UnitUsage> Search(@RequestParam String keyword) {

        return unitUsageRepository.search(keyword);
    }
}
