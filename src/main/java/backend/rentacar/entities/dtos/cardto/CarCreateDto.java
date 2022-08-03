package backend.rentacar.entities.dtos.cardto;

import backend.rentacar.entities.concretes.Brand;
import backend.rentacar.entities.concretes.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarCreateDto {
    @NotNull
    @UniqueElements
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
