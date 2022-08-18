package backend.rentacar.entities.dtos.carimagedto;

import backend.rentacar.entities.concretes.Car;
import backend.rentacar.entities.concretes.CarImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageViewDto {
    private int carImageId;

    private String imagePath;

    private Car car;
    public static CarImageViewDto of(CarImage carImage){
        return new CarImageViewDto(carImage.getCarImageId(),carImage.getImagePath(), carImage.getCar());
    }
}
