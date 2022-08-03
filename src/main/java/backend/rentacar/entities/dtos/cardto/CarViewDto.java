package backend.rentacar.entities.dtos.cardto;

import backend.rentacar.entities.concretes.Brand;
import backend.rentacar.entities.concretes.CarImage;
import backend.rentacar.entities.concretes.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    public static CarViewDto of(CarImage car){
        return new CarViewDto(car.getCarName(),car.getDailyPrice(),car.getModelYear(),car.getDescription(),car.getBrand(),car.getColor());
    }
}
