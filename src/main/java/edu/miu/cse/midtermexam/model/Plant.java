package edu.miu.cse.midtermexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "plant_id")
    private Integer plantId ;
    private String plantName ;
    private String plantType;
    LocalDate plantDate ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="garden_id")
    Garden garden ;

    public Plant(String plantName, String plantType, LocalDate plantDate) {
        this.plantName = plantName;
        this.plantType = plantType;
        this.plantDate = plantDate;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "plantId=" + plantId +
                ", plantName='" + plantName + '\'' +
                ", plantType='" + plantType + '\'' +
                ", plantDate=" + plantDate +
                ", garden=" + garden.getGardenName() +
                '}';
    }
}
