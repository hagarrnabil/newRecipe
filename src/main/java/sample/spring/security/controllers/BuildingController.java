package sample.spring.security.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.DTOModels.BuildingDTO;
import sample.spring.security.models.Building;
import sample.spring.security.repositories.BuildingRepository;
import sample.spring.security.services.BuildingService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class BuildingController {
    @Autowired
    private ModelMapper modelMapper;
    private BuildingService buildingService;

    public BuildingController(BuildingService buildingService) {
        super();
        this.buildingService = buildingService;
    }

    @GetMapping("/buildings")
    public List<BuildingDTO> getAllBuildings() {

        return buildingService.getAllBuildings().stream().map(building -> modelMapper.map(building, BuildingDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/buildings/{building_code}")
    public ResponseEntity<BuildingDTO> getBuildingById(@PathVariable(name = "building_code") Long building_code) {
        Optional<Building> building = buildingService.getBuildingById(building_code);

        // convert entity to DTO
        BuildingDTO buildingResponse = modelMapper.map(building, BuildingDTO.class);

        return ResponseEntity.ok().body(buildingResponse);
    }

    @PostMapping("/buildings")
    public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingDTO buildingDTO) {

        // convert DTO to entity
        Building buildingRequest = modelMapper.map(buildingDTO, Building.class);

        Building building = buildingService.createBuilding(buildingRequest);

        // convert entity to DTO
        BuildingDTO buildingResponse = modelMapper.map(building, BuildingDTO.class);

        return new ResponseEntity<BuildingDTO>(buildingResponse, HttpStatus.CREATED);
    }

    @DeleteMapping("/buildings/{building_code}")
    void deleteBuilding(@PathVariable Long building_code) {
        buildingService.deleteBuilding(building_code);
    }

    @PutMapping("/buildings/{building_code}")
    public ResponseEntity<BuildingDTO> updateBuilding(@PathVariable long building_code, @RequestBody BuildingDTO buildingDTO) {

        // convert DTO to Entity
        Building buildingRequest = modelMapper.map(buildingDTO, Building.class);

        Building building = buildingService.updateBuilding(building_code, buildingRequest);

        // entity to DTO
        BuildingDTO buildingResponse = modelMapper.map(building, BuildingDTO.class);

        return ResponseEntity.ok().body(buildingResponse);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/buildings/search")
//    @ResponseBody
//    public List<Building> Search(@RequestParam String keyword) {
//
//        return buildingRepository.search(keyword);
//    }

}
