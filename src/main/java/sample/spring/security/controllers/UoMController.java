package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Fixture;
import sample.spring.security.models.UnitOfMeasurements;
import sample.spring.security.repositories.UoMRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UoMController {
    @Autowired
    UoMRepository uoMRepository;

    public UoMController(UoMRepository uoMRepository) {
        this.uoMRepository = uoMRepository;
    }
    @GetMapping("/uom")
    Iterable<UnitOfMeasurements> all() {
        return uoMRepository.findAll();
    }

    @RequestMapping(value = "/uom/{unitOfMeasurementcode}", method = RequestMethod.GET)
    public Optional<UnitOfMeasurements> findByIds(@PathVariable @NotNull Long unitOfMeasurement_code) {

        return uoMRepository.findById(unitOfMeasurement_code);
    }

    @PostMapping("/uom")
    UnitOfMeasurements newUom(@RequestBody UnitOfMeasurements newUom) {
        return uoMRepository.save(newUom);
    }

    @DeleteMapping("/uom/{unitOfMeasurement_code}")
    void deleteUom(@PathVariable Long unitOfMeasurement_code) {
        uoMRepository.deleteById(unitOfMeasurement_code);
    }

    @PutMapping("/uom/{unitOfMeasurement_code}")
    UnitOfMeasurements updateUom(@RequestBody UnitOfMeasurements newUom, @PathVariable Long unitOfMeasurement_code) {

        return uoMRepository.findById(unitOfMeasurement_code).map(unitOfMeasurements -> {
            unitOfMeasurements.setUnitOfMeasurement_code(newUom.getUnitOfMeasurement_code());
            unitOfMeasurements.setUnitOfMeasurementID(newUom.getUnitOfMeasurementID());
            unitOfMeasurements.setUnitOfMeasurementDesc(newUom.getUnitOfMeasurementDesc());
            return uoMRepository.save(newUom);
        }).orElseGet(() -> {
            newUom.setUnitOfMeasurement_code(unitOfMeasurement_code);
            return uoMRepository.save(newUom);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/uom/search")
    @ResponseBody
    public List<UnitOfMeasurements> Search(@RequestParam String keyword) {

        return uoMRepository.search(keyword);
    }
}
