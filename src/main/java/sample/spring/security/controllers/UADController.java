package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.UnitAreaDetails;
import sample.spring.security.models.UnitFloor;
import sample.spring.security.repositories.UADRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class UADController {
    @Autowired
    UADRepository uadRepository;

    public UADController(UADRepository uadRepository) {
        this.uadRepository = uadRepository;
    }
    @GetMapping("/uad")
    Iterable<UnitAreaDetails> all() {
        return uadRepository.findAll();
    }

    @RequestMapping(value = "/uad/{area_code}", method = RequestMethod.GET)
    public Optional<UnitAreaDetails> findByIds(@PathVariable @NotNull Long area_code) {

        return uadRepository.findById(area_code);
    }

    @PostMapping("/uad")
    UnitAreaDetails newUAD(@RequestBody UnitAreaDetails newUAD) {
        return uadRepository.save(newUAD);
    }

    @DeleteMapping("/uad/{area_code}")
    void deleteUAD(@PathVariable Long area_code) {
        uadRepository.deleteById(area_code);
    }

    @PutMapping("/uad/{area_code}")
    UnitAreaDetails updateUAD(@RequestBody UnitAreaDetails newUAD, @PathVariable Long area_code) {

        return uadRepository.findById(area_code).map(unitAreaDetails -> {
            unitAreaDetails.setArea_code(newUAD.getArea_code());
            unitAreaDetails.setArea(newUAD.getArea());
            unitAreaDetails.setAreaID(newUAD.getAreaID());
            unitAreaDetails.setAmount(newUAD.getAmount());
            unitAreaDetails.setNoOfRooms(newUAD.getNoOfRooms());
            return uadRepository.save(newUAD);
        }).orElseGet(() -> {
            newUAD.setArea_code(area_code);
            return uadRepository.save(newUAD);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/uad/search")
    @ResponseBody
    public List<UnitAreaDetails> Search(@RequestParam String keyword) {

        return uadRepository.search(keyword);
    }
}

