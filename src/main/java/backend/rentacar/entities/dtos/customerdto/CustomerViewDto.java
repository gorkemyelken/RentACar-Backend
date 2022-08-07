package backend.rentacar.entities.dtos.customerdto;

import backend.rentacar.entities.concretes.Customer;
import backend.rentacar.entities.concretes.Rental;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerViewDto {
    private String firstName;

    private String lastName;

    private String nationalityNumber;

    private int birthYear;

    private String email;

    private List<Rental> rentals;

    public static CustomerViewDto of(Customer customer){
        return new CustomerViewDto(customer.getFirstName(), customer.getLastName(), customer.getNationalityNumber(), customer.getBirthYear(), customer.getEmail(), customer.getRentals());
    }
}
