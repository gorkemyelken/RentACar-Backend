package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.UserService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.repositories.abstracts.UserRepository;
import backend.rentacar.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userRepository.findAll(),"Users listed.");
    }

    @Override
    public Result add(User user) {
        this.userRepository.save(user);
        return new SuccessResult("User added.");
    }

    @Override
    public DataResult<User> findByEmail(String email) {
        return new SuccessDataResult<User>(this.userRepository.findByEmail(email),"User listed by email.");
    }
}
