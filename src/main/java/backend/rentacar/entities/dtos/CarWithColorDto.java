package backend.rentacar.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarWithColorDto {
    private int carId;
    private String carName;
    private String colorName;
}
