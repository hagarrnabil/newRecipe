package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.BuildingType;
import sample.spring.security.models.Cities;
import sample.spring.security.repositories.BuildingTypeRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class BuildingTypeController {
    @Autowired
    private final BuildingTypeRepository buildingTypeRepository;

    public BuildingTypeController(BuildingTypeRepository buildingTypeRepository) {
        this.buildingTypeRepository = buildingTypeRepository;
    }

    @GetMapping("/buildingtype")
    Iterable<BuildingType> all() {
        return buildingTypeRepository.findAll();
    }

    @RequestMapping(value = "/buildingtype/{buildingType_code}", method = RequestMethod.GET)
    public Optional<BuildingType> findByIds(@PathVariable @NotNull Long buildingType_code) {

        return buildingTypeRepository.findById(buildingType_code);
    }

    @PostMapping("/buildingtype")
    BuildingType newBuildingType(@RequestBody BuildingType newBuildingType) {
        return buildingTypeRepository.save(newBuildingType);
    }

    @DeleteMapping("/buildingtype/{buildingType_code}")
    void deleteBuildingType(@PathVariable Long buildingType_code) {
        buildingTypeRepository.deleteById(buildingType_code);
    }

    @PutMapping("/buildingtype/{buildingType_code}")
    BuildingType updateBuildingType(@RequestBody BuildingType newBuildingType, @PathVariable Long buildingType_code) {

        return buildingTypeRepository.findById(buildingType_code).map(buildingType -> {
            buildingType.setBuildingType_code(newBuildingType.getBuildingType_code());
            buildingType.setBuildingTypeID(newBuildingType.getBuildingTypeID());
            buildingType.setBuildTypeDesc(newBuildingType.getBuildTypeDesc());
            return buildingTypeRepository.save(newBuildingType);
        }).orElseGet(() -> {
            newBuildingType.setBuildingType_code(buildingType_code);
            return buildingTypeRepository.save(newBuildingType);
        });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/buildingtype/search")
    @ResponseBody
    public List<BuildingType> Search(@RequestParam String keyword) {

        return buildingTypeRepository.search(keyword);
    }
}
