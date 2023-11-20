package sample.spring.security.controllers;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.models.Building;
import sample.spring.security.models.Project;
import sample.spring.security.repositories.BuildingRepository;
import sample.spring.security.repositories.CompanyRepository;
import sample.spring.security.repositories.ProjectRepository;

import java.util.List;
import java.util.Optional;

@RestController
public class BuildingController {
    @Autowired
    private final CompanyRepository companyRepository;
    @Autowired
    private  final ProjectRepository projectRepository;
    @Autowired
    private final BuildingRepository buildingRepository;

    public BuildingController(CompanyRepository companyRepository, ProjectRepository projectRepository, BuildingRepository buildingRepository) {
        this.companyRepository = companyRepository;
        this.projectRepository = projectRepository;
        this.buildingRepository = buildingRepository;
    }

    @GetMapping("/buildings")
    Iterable<Building> all() {
        return buildingRepository.findAll();
    }

    @RequestMapping(value = "/buildings/{building_code}", method = RequestMethod.GET)
    public Optional<Building> findByIds(@PathVariable @NotNull Long building_code) {

        return buildingRepository.findById(building_code);
    }

    @PostMapping("/buildings")
    Building newBuilding(@RequestBody Building newBuilding) {

        return buildingRepository.save(newBuilding);
    }

    @DeleteMapping("/buildings/{building_code}")
    void deleteBuilding(@PathVariable Long building_code) {
        buildingRepository.deleteById(building_code);
    }

    @PutMapping("/buildings/{building_code}")
    Building updateBuilding(@RequestBody Building newBuilding, @PathVariable Long building_code) {

                return buildingRepository.findById(building_code).map(building -> {
                    building.setBuilding_code(newBuilding.getBuilding_code());
                    building.setBuildingDescription(newBuilding.getBuildingDescription());
                    building.setBuildingID(newBuilding.getBuildingID());
                    building.setNumberOfFloors(newBuilding.getNumberOfFloors());
                    building.setValidFrom(newBuilding.getValidFrom());
                    building.setOldNumber(newBuilding.getOldNumber());
                    return buildingRepository.save(newBuilding);
                }).orElseGet(() -> {
                    newBuilding.setBuilding_code(building_code);
                    return buildingRepository.save(newBuilding);
                });
    }

    @RequestMapping(method = RequestMethod.GET, value = "/buildings/search")
    @ResponseBody
    public List<Building> Search(@RequestParam String keyword) {

        return buildingRepository.search(keyword);
    }

}
