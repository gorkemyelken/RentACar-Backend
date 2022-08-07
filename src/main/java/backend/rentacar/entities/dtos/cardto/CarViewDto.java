package backend.rentacar.entities.dtos.cardto;

import backend.rentacar.entities.concretes.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarViewDto {
    private String carName;

    private double dailyPrice;

    private int modelYear;

    private String description;

    private Brand brand;

    private Color color;

    private List<CarImage> carImages;

    private Rental rental;
    public static CarViewDto of(Car car){
        return new CarViewDto(car.getCarName(),car.getDailyPrice(),car.getModelYear(),car.getDescription(),car.getBrand(),car.getColor(), car.getCarImages(), car.getRental());
    }
}
