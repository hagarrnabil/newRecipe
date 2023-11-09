package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Cities;
import sample.spring.security.models.CompanyCode;
import sample.spring.security.repositories.CitiesRepository;
import sample.spring.security.repositories.CompanyCodeRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class CitiesController {
    @Autowired
    private final CitiesRepository citiesRepository;

    public CitiesController(CitiesRepository citiesRepository) {
        this.citiesRepository = citiesRepository;
    }

    @GetMapping("/cities")
    Iterable<Cities> all() {
        return citiesRepository.findAll();
    }

    @RequestMapping(value = "/cities/{cities_code}", method = RequestMethod.GET)
    public Optional<Cities> findByIds(@PathVariable @NotNull Long cities_code) {

        return citiesRepository.findById(cities_code);
    }

    @PostMapping("/cities")
    Cities newCities(@RequestBody Cities newCities) {
        return citiesRepository.save(newCities);
    }

    @DeleteMapping("/cities/{cities_code}")
    void deleteCities(@PathVariable Long cities_code) {
        citiesRepository.deleteById(cities_code);
    }

    @PutMapping("/cities/{cities_code}")
    Cities updateCities(@RequestBody Cities newCities, @PathVariable Long cities_code) {

        return citiesRepository.findById(cities_code).map(cities -> {
            cities.setCitiesID(newCities.getCitiesID());
            cities.setRegionalLocation(newCities.getRegionalLocation());
            cities.setCities_code(newCities.getCities_code());
            return citiesRepository.save(newCities);
        }).orElseGet(() -> {
            newCities.setCities_code(cities_code);
            return citiesRepository.save(newCities);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/cities/search")
    @ResponseBody
    public List<Cities> Search(@RequestParam String keyword) {

        return citiesRepository.search(keyword);
    }
}
