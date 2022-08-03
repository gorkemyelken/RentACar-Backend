package backend.rentacar.entities.dtos.rentaldto;

import backend.rentacar.entities.concretes.Car;
import backend.rentacar.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalUpdateDto {
    @NotNull
    private Car car;

    @NotNull
    private Customer customer;

    @NotNull
    private java.sql.Date rentDate;

    @NotNull
    private java.sql.Date returnDate;
}
