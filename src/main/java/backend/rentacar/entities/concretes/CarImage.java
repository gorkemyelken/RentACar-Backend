package backend.rentacar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="car_images")
@AllArgsConstructor
@NoArgsConstructor
public class CarImage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_image_id")
    private int carImageId;

    @Column(name="image_path")
    private String imagePath;

    @ManyToOne()
    @JoinColumn(name="car_id")
    private Car car;
}
