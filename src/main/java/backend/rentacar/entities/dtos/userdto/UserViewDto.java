package backend.rentacar.entities.dtos.userdto;

import backend.rentacar.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserViewDto {
    private String email;
    public static UserViewDto of(User user){
        return new UserViewDto(user.getEmail());
    }
}
