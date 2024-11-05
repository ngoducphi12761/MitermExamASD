package edu.miu.cse.midtermexam.service.impl;

import edu.miu.cse.midtermexam.model.Plant;
import edu.miu.cse.midtermexam.repository.PlantRepository;
import edu.miu.cse.midtermexam.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlantServiceImpl implements PlantService {
    private final PlantRepository plantRepository;
    @Override
    public Optional<Plant> addNewPlant(Plant Plant) {
        return Optional.of(plantRepository.save(Plant));
    }

    @Override
    public Optional<Plant> findByPlantName(String PlantName) {
        return plantRepository.findByPlantName(PlantName);
    }

    @Override
    public void deletePlant(Plant Plant) {
        plantRepository.delete(Plant);
    }

    @Override
    public Optional<Plant> updatePlant(Plant Plant) {
        return Optional.of(plantRepository.save(Plant));
    }

    @Override
    public List<Plant> getAllPlantsByName() {
        return plantRepository.displayPlantsSortedByName();
    }

    @Override
    public List<Plant> getAllPlantsByDate() {
        return plantRepository.displayPlantsSortedByDate();
    }
}

