package backend.rentacar.entities.dtos.cardto;

import backend.rentacar.entities.concretes.Brand;
import backend.rentacar.entities.concretes.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarUpdateDto {
    @NotNull
    private String carName;

    @NotNull
    private double dailyPrice;

    @NotNull
    private int modelYear;

    @NotNull
    private String description;

    @NotNull
    private Brand brand;

    @NotNull
    private Color color;
}
