package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.User;

import java.util.List;

public interface UserService {
    DataResult<List<User>> getall();
    Result add(User user);
    DataResult<User> findByEmail(String email);
}
