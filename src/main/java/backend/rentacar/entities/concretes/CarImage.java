package backend.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="car_images")
@AllArgsConstructor
@NoArgsConstructor
public class CarImage {
    public CarImage(String imagePath, Car car){
        this.imagePath = imagePath;
        this.car = car;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_image_id")
    private int carImageId;

    @Column(name="image_path")
    private String imagePath;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="car_id")
    @JsonIgnore
    private Car car;
}
