package backend.rentacar.entities.dtos.carimagedto;

import backend.rentacar.entities.concretes.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageCreateDto {
    @NotNull
    private String imagePath;

    @NotNull
    private Car car;
}
