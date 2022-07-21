package backend.rentacar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name="cars")
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="car_id")
    private int carId;

    @Column(name="car_name")
    private String carName;

    @Column(name="daily_price")
    private double dailyPrice;

    @Column(name="model_year")
    private int modelYear;

    @Column(name="description")
    private String description;

    @ManyToOne()
    @JoinColumn(name="brand_id")
    private Brand brand;

    @ManyToOne()
    @JoinColumn(name="color_id")
    private Color color;

    @OneToOne
    private Rental rental;
}
