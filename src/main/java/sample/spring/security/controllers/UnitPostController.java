package sample.spring.security.controllers;


import jakarta.validation.constraints.NotNull;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sample.spring.security.DTOModels.ProjectDTO;
import sample.spring.security.DTOModels.UnitDTO;
import sample.spring.security.models.Building;
import sample.spring.security.models.Project;
import sample.spring.security.models.Unit;
import sample.spring.security.repositories.BuildingRepository;
import sample.spring.security.repositories.CompanyRepository;
import sample.spring.security.repositories.ProjectRepository;
import sample.spring.security.repositories.UnitRepository;
import sample.spring.security.services.UnitService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class UnitPostController {
    @Autowired
    private final ModelMapper modelMapper;

    @Autowired
    private final UnitRepository unitrepository;
    private UnitService unitService;

    public UnitPostController(ModelMapper modelMapper, UnitRepository unitrepository, UnitService unitService) {
        super();
        this.modelMapper = modelMapper;
        this.unitrepository = unitrepository;
        this.unitService = unitService;
    }

    @GetMapping("/units")
    public List<UnitDTO> getAllUnits() {

        return unitService.getAllUnits().stream().map(unit -> modelMapper.map(unit, UnitDTO.class))
                .collect(Collectors.toList());
    }


    @GetMapping("/units/{unit_code}")
    public ResponseEntity<UnitDTO> getUnitById(@PathVariable(name = "unit_code") Long unit_code) {
        Optional<Unit> unit = unitService.getUnitById(unit_code);

        // convert entity to DTO
        UnitDTO unitResponse = modelMapper.map(unit, UnitDTO.class);

        return ResponseEntity.ok().body(unitResponse);
    }

    @PostMapping("/units")
    public ResponseEntity<UnitDTO> createUnit(@RequestBody UnitDTO unitDTO) {

        // convert DTO to entity
        Unit unitRequest = modelMapper.map(unitDTO, Unit.class);

        Unit unit = unitService.createUnit(unitRequest);

        // convert entity to DTO
        UnitDTO unitResponse = modelMapper.map(unit, UnitDTO.class);

        return new ResponseEntity<UnitDTO>(unitResponse, HttpStatus.CREATED);
    }


    @DeleteMapping("/units/{unit_code}")
    void deleteUnit(@PathVariable Long unit_code) {
        unitService.deleteUnit(unit_code);
    }

    @PutMapping("/units/{unit_code}")
    public ResponseEntity<UnitDTO> updateUnit(@PathVariable long unit_code, @RequestBody UnitDTO unitDTO) {

        // convert DTO to Entity
        Unit unitRequest = modelMapper.map(unitDTO, Unit.class);

        Unit unit = unitService.updateUnit(unit_code, unitRequest);

        // entity to DTO
        UnitDTO unitResponse = modelMapper.map(unit, UnitDTO.class);

        return ResponseEntity.ok().body(unitResponse);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/units/search")
    @ResponseBody
    public List<Unit> Search(@RequestParam String keyword) {

        return unitrepository.search(keyword);
    }

}
