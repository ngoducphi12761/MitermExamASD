package edu.miu.cse.midtermexam.service;

import edu.miu.cse.midtermexam.model.Plant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface PlantService {
    Optional<Plant> addNewPlant(Plant Plant);
    Optional<Plant> findByPlantName(String PlantName);
    void deletePlant(Plant Plant);
    Optional<Plant>updatePlant(Plant Plant);
    List<Plant> getAllPlantsByName();
    List<Plant> getAllPlantsByDate();
}
