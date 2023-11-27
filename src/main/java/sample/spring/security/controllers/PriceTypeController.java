package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.PriceType;
import sample.spring.security.models.UnitFloor;
import sample.spring.security.repositories.PriceTypeRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class PriceTypeController {
    @Autowired
    PriceTypeRepository priceTypeRepository;

    public PriceTypeController(PriceTypeRepository priceTypeRepository) {
        this.priceTypeRepository = priceTypeRepository;
    }
    @GetMapping("/priceType")
    Iterable<PriceType> all() {
        return priceTypeRepository.findAll();
    }

    @RequestMapping(value = "/priceType/{priceType_code}", method = RequestMethod.GET)
    public Optional<PriceType> findByIds(@PathVariable @NotNull Long priceType_code) {

        return priceTypeRepository.findById(priceType_code);
    }

    @PostMapping("/priceType")
    PriceType newpriceType(@RequestBody PriceType newpriceType) {
        return priceTypeRepository.save(newpriceType);
    }

    @DeleteMapping("/priceType/{priceType_code}")
    void deletepriceType(@PathVariable Long priceType_code) {
        priceTypeRepository.deleteById(priceType_code);
    }

    @PutMapping("/priceType/{priceType_code}")
    PriceType updatepriceType(@RequestBody PriceType newpriceType, @PathVariable Long priceType_code) {

        return priceTypeRepository.findById(priceType_code).map(priceType -> {
            priceType.setPriceType_code(newpriceType.getPriceType_code());
            priceType.setPriceTypeDescription(newpriceType.getPriceTypeDescription());
            priceType.setPriceTypeID(newpriceType.getPriceTypeID());
            return priceTypeRepository.save(newpriceType);
        }).orElseGet(() -> {
            newpriceType.setPriceType_code(priceType_code);
            return priceTypeRepository.save(newpriceType);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/priceType/search")
    @ResponseBody
    public List<PriceType> Search(@RequestParam String keyword) {

        return priceTypeRepository.search(keyword);
    }
}
