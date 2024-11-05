package edu.miu.cse.midtermexam.service.impl;

import edu.miu.cse.midtermexam.model.Garden;
import edu.miu.cse.midtermexam.repository.GardenRepository;
import edu.miu.cse.midtermexam.service.GardenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GardenServiceImpl implements GardenService {
    private final GardenRepository gardenRepository;
    @Override
    public Optional<Garden> findGardenByGardenName(String gardenName) {
        return gardenRepository.findByGardenName(gardenName);
    }

    @Override
    public Optional<Garden> addNewGarden(Garden garden) {
        return Optional.of(gardenRepository.save(garden));
    }

    @Override
    public void deleteGarden(Garden garden) {
        gardenRepository.delete(garden);
    }

    @Override
    public Optional<Garden> updateGarden(Garden garden) {
        return Optional.empty();
    }

    @Override
    public List<Garden> getGardenList() {
        return gardenRepository.displayAllGardens();
    }
}
