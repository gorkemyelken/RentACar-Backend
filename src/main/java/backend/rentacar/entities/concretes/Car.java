package backend.rentacar.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="cars")
public class Car {
    @Id
    @GeneratedValue
    @Column(name="car_id")
    private int carId;

    @Column(name="brand_id")
    private Brand brand;

    @Column(name="color_id")
    private Color color;

    @Column(name="car_name")
    private String carName;

    @Column(name="daily_price")
    private double dailyPrice;

    @Column(name="model_year")
    private int modelYear;

    @Column(name="description")
    private String description;
}
