package sample.spring.security.services;

import sample.spring.security.models.Building;

import java.util.List;
import java.util.Optional;

public interface BuildingService {
    List<Building> getAllBuildings();

    Building createBuilding(Building building);

    Building updateBuilding(long building_code, Building building);

    void deleteBuilding(long building_code);

    Optional<Building> getBuildingById(long building_code);
}
