package sample.spring.security.services;

import org.springframework.stereotype.Service;
import sample.spring.security.models.Building;
import sample.spring.security.repositories.BuildingRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BuildingServiceImpl implements BuildingService{

    private final BuildingRepository buildingRepository;

    public BuildingServiceImpl(BuildingRepository buildingRepository) {
        super();
        this.buildingRepository = buildingRepository;
    }

    @Override
    public List<Building> getAllBuildings() {
        return buildingRepository.findAll();
    }

    @Override
    public Building createBuilding(Building building) {
        return buildingRepository.save(building);
    }

    @Override
    public Building updateBuilding(long building_code, Building building) {
        return buildingRepository.findById(building_code).map(building1 -> {
            building1.setBuildingID(building.getBuildingID());
            building1.setBuilding_code(building.getBuilding_code());
            building1.setBuildingDescription(building.getBuildingDescription());
            building1.setOldNumber(building.getOldNumber());
            building1.setNumberOfFloors(building.getNumberOfFloors());
            building1.setValidFrom(building.getValidFrom());
            return buildingRepository.save(building);
        }).orElseGet(() -> {
            building.setBuilding_code(building_code);
            return buildingRepository.save(building);
        });
    }

    @Override
    public void deleteBuilding(long building_code) {
        buildingRepository.deleteById(building_code);
    }

    @Override
    public Optional<Building> getBuildingById(long building_code) {
        return buildingRepository.findById(building_code);
    }
}
