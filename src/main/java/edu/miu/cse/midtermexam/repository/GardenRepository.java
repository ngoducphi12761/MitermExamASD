package edu.miu.cse.midtermexam.repository;

import edu.miu.cse.midtermexam.model.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface GardenRepository extends JpaRepository<Garden, Integer> {
    Optional<Garden> findByGardenName(String gardenName);

    @Query("SELECT p FROM Garden p")
    List<Garden> displayAllGardens();
}
