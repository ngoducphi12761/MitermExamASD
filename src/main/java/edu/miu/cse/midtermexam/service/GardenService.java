package edu.miu.cse.midtermexam.service;

import edu.miu.cse.midtermexam.model.Garden;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public interface GardenService {
    Optional<Garden> findGardenByGardenName(String gardenName);
    Optional<Garden> addNewGarden(Garden garden);
    void deleteGarden(Garden garden);
    Optional<Garden> updateGarden(Garden garden);
    List<Garden> getGardenList();
}
