package backend.rentacar.entities.dtos.customerdto;

import backend.rentacar.entities.concretes.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerViewDto {
    private String firstName;

    private String lastName;

    private String nationalityNumber;

    private int birthYear;

    private String email;

    public static CustomerViewDto of(Customer customer){
        return new CustomerViewDto(customer.getFirstName(), customer.getLastName(), customer.getNationalityNumber(), customer.getBirthYear(), customer.getEmail());
    }
}