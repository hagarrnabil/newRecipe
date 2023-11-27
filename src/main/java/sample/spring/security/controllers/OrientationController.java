package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Fixture;
import sample.spring.security.models.Orientation;
import sample.spring.security.repositories.OrientationRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class OrientationController {
    @Autowired
    OrientationRepository orientationRepository;

    public OrientationController(OrientationRepository orientationRepository) {
        this.orientationRepository = orientationRepository;
    }
    @GetMapping("/orientation")
    Iterable<Orientation> all() {
        return orientationRepository.findAll();
    }

    @RequestMapping(value = "/orientation/{orientation_code}", method = RequestMethod.GET)
    public Optional<Orientation> findByIds(@PathVariable @NotNull Long orientation_code) {

        return orientationRepository.findById(orientation_code);
    }

    @PostMapping("/orientation")
    Orientation newOrientation(@RequestBody Orientation newOrientation) {
        return orientationRepository.save(newOrientation);
    }

    @DeleteMapping("/orientation/{orientation_code}")
    void deleteOrientation(@PathVariable Long orientation_code) {
        orientationRepository.deleteById(orientation_code);
    }

    @PutMapping("/orientation/{orientation_code}")
    Orientation updateOrientation(@RequestBody Orientation newOrientation, @PathVariable Long orientation_code) {

        return orientationRepository.findById(orientation_code).map(orientation -> {
            orientation.setOrientation_code(newOrientation.getOrientation_code());
            orientation.setOrientationID(newOrientation.getOrientationID());
            orientation.setOrientationDescription(newOrientation.getOrientationDescription());
            return orientationRepository.save(newOrientation);
        }).orElseGet(() -> {
            newOrientation.setOrientation_code(orientation_code);
            return orientationRepository.save(newOrientation);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/orientation/search")
    @ResponseBody
    public List<Orientation> Search(@RequestParam String keyword) {

        return orientationRepository.search(keyword);
    }
}
