package edu.miu.cse.midtermexam;

import edu.miu.cse.midtermexam.model.Garden;
import edu.miu.cse.midtermexam.model.Plant;
import edu.miu.cse.midtermexam.service.GardenService;
import edu.miu.cse.midtermexam.service.PlantService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RequiredArgsConstructor
public class MidtermExamApplication {
    private final GardenService gardenService;
    private final PlantService plantService;

    public static void main(String[] args) {
        SpringApplication.run(MidtermExamApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Garden garden1 = new Garden("Vegetable Patch", 50.0);
            Garden garden2 = new Garden("Herb Garden", 20.0);
            gardenService.addNewGarden(garden1);
            System.out.println(gardenService.addNewGarden(garden2));
            Plant plant1 = new Plant("Tomato", "Vegetable", LocalDate.of(2024, 3, 10));
            plant1.setGarden(garden1);
            Plant plant2 = new Plant("Carrot", "Vegetable", LocalDate.of(2024, 2, 20));
            plant2.setGarden(garden1);
            Plant plant3 = new Plant("Basii", "Herb", LocalDate.of(2024, 4, 5));
            plant3.setGarden(garden2);

            plantService.addNewPlant(plant1);
            plantService.addNewPlant(plant2);
            plantService.addNewPlant(plant3);
            // Display all gardens
            System.out.println("Display all gardens");
            List<Garden> gardenList = gardenService.getGardenList();
            gardenList.forEach(System.out::println);
            // Display all plants sorted by plant's name
            System.out.println("Display all plants sorted by plants' name");
            List<Plant> plantListByName = plantService.getAllPlantsByName();
            plantListByName.forEach(System.out::println);

            // Display all plants sorted by plant's date
            System.out.println("Display all plants sorted by plants' date");

            List<Plant> plantListByDate = plantService.getAllPlantsByDate();
            plantListByDate.forEach(System.out::println);

            // delete a plant
             plantService.findByPlantName("Tomato").ifPresent(
                    plant -> {
                        plantService.deletePlant(plant);
                    }
            );
            List<Plant> plantListByDate2 = plantService.getAllPlantsByDate();
            plantListByDate2.forEach(System.out::println);


        };
    }
}
