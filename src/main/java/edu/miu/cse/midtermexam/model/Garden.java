package edu.miu.cse.midtermexam.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Garden {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "garden_id")
    private Integer gardenId;
    private String gardenName;
    private Double gardenSize;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "garden")
    private List<Plant> plantList;

    public Garden(String gardenName, Double gardenSize) {
        this.gardenName = gardenName;
        this.gardenSize = gardenSize;
    }

    @Override
    public String toString() {
        return "Garden{" +
                "gardenId=" + gardenId +
                ", gardenName='" + gardenName + '\'' +
                ", gardenSize=" + gardenSize +
                '}';
    }
}
