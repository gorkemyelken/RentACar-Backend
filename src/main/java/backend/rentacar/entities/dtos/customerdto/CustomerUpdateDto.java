package backend.rentacar.entities.dtos.customerdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerUpdateDto {
    @NotNull
    @NotBlank
    private String firstName;

    @NotNull
    @NotBlank
    private String lastName;

    @NotNull
    @NotBlank
    @UniqueElements
    private String nationalityNumber;

    @NotNull
    private int birthYear;

    @Email
    @NotNull
    @NotBlank
    @UniqueElements
    private String email;

    @NotNull
    @NotBlank
    private String password;
}
