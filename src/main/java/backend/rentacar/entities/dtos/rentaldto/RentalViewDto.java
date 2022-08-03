package backend.rentacar.entities.dtos.rentaldto;

import backend.rentacar.entities.concretes.Car;
import backend.rentacar.entities.concretes.Customer;
import backend.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RentalViewDto {
    private Car car;

    private Customer customer;

    private java.sql.Date rentDate;

    private java.sql.Date returnDate;

    public static RentalViewDto of(Rental rental){
        return new RentalViewDto(rental.getCar(), rental.getCustomer(),rental.getRentDate(), rental.getReturnDate());
    }
}
