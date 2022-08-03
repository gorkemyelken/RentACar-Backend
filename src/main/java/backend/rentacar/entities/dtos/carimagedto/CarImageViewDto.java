package backend.rentacar.entities.dtos.carimagedto;

import backend.rentacar.entities.concretes.CarImage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageViewDto {
    private String imagePath;
    public static CarImageViewDto of(CarImage carImage){
        return new CarImageViewDto(carImage.getImagePath());
    }
}
