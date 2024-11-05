package edu.miu.cse.midtermexam.repository;

import edu.miu.cse.midtermexam.model.Plant;
import jakarta.validation.constraints.Max;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlantRepository extends JpaRepository<Plant, Integer> {
    Optional<Plant> findByPlantName(String name);

    @Query("SELECT p FROM Plant p ORDER BY p.plantName ASC")
    List<Plant> displayPlantsSortedByName();

    @Query("SELECT p FROM Plant p ORDER BY p.plantDate ASC")
    List<Plant> displayPlantsSortedByDate();
}
