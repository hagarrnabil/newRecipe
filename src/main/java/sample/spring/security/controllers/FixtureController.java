package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Fixture;
import sample.spring.security.models.Profit;
import sample.spring.security.repositories.FixtureRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class FixtureController {
    @Autowired
    FixtureRepository fixtureRepository;

    public FixtureController(FixtureRepository fixtureRepository) {
        this.fixtureRepository = fixtureRepository;
    }
    @GetMapping("/fixture")
    Iterable<Fixture> all() {
        return fixtureRepository.findAll();
    }

    @RequestMapping(value = "/fixture/{fixture_code}", method = RequestMethod.GET)
    public Optional<Fixture> findByIds(@PathVariable @NotNull Long fixture_code) {

        return fixtureRepository.findById(fixture_code);
    }

    @PostMapping("/fixture")
    Fixture newFixture(@RequestBody Fixture newFixture) {
        return fixtureRepository.save(newFixture);
    }

    @DeleteMapping("/fixture/{fixture_code}")
    void deleteFixture(@PathVariable Long fixture_code) {
        fixtureRepository.deleteById(fixture_code);
    }

    @PutMapping("/fixture/{fixture_code}")
    Fixture updateFixture(@RequestBody Fixture newFixture, @PathVariable Long fixture_code) {

        return fixtureRepository.findById(fixture_code).map(fixture -> {
            fixture.setFixture_code(newFixture.getFixture_code());
            fixture.setFixtureDescription(newFixture.getFixtureDescription());
            fixture.setFixtureID(newFixture.getFixtureID());
            return fixtureRepository.save(newFixture);
        }).orElseGet(() -> {
            newFixture.setFixture_code(fixture_code);
            return fixtureRepository.save(newFixture);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/fixture/search")
    @ResponseBody
    public List<Fixture> Search(@RequestParam String keyword) {

        return fixtureRepository.search(keyword);
    }
}
