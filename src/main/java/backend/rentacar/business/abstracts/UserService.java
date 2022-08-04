package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.userdto.UserCreateDto;
import backend.rentacar.entities.dtos.userdto.UserUpdateDto;
import backend.rentacar.entities.dtos.userdto.UserViewDto;

import java.util.List;

public interface UserService {
    DataResult<List<UserViewDto>> getAll();
    DataResult<UserViewDto> add(UserCreateDto userCreateDTO);
    DataResult<UserViewDto> findByEmail(String email);
    DataResult<UserViewDto> update(int userId, UserUpdateDto userUpdateDto);
    DataResult<UserViewDto> delete(int userId);
}
