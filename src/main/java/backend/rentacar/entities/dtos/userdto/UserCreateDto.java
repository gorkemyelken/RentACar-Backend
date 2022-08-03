package backend.rentacar.entities.dtos.userdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateDto {
    @NotNull
    @Email
    @NotBlank
    @UniqueElements
    private String email;

    @NotNull
    @NotBlank
    @Size(min=6, max=20)
    private String password;
}
