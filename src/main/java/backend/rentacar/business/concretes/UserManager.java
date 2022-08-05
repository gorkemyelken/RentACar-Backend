package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.UserService;
import backend.rentacar.business.constants.Messages;
import backend.rentacar.core.utilities.mapping.ModelMapperService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.ErrorDataResult;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.entities.dtos.userdto.UserCreateDto;
import backend.rentacar.entities.dtos.userdto.UserUpdateDto;
import backend.rentacar.entities.dtos.userdto.UserViewDto;
import backend.rentacar.repositories.abstracts.UserRepository;
import backend.rentacar.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserManager implements UserService {

    private final UserRepository userRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public UserManager(UserRepository userRepository, ModelMapperService modelMapperService) {
        this.userRepository = userRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<UserViewDto>> getAll() {
        List<User> users = this.userRepository.findAll();
        List<UserViewDto> result = users.stream().map(user -> this.modelMapperService.forDto().map(user, UserViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.GlobalMessages.DATA_LISTED);
    }

    @Override
    public DataResult<UserViewDto> add(UserCreateDto userCreateDto) {
        if(checkIfUserEmailExists(userCreateDto.getEmail())){
            return new ErrorDataResult<>(Messages.UserMessages.USER_EMAIL_ALREADY_EXIST);
        }
        else{
            User user = this.userRepository.save(new User(userCreateDto.getEmail(),userCreateDto.getPassword()));
            return new SuccessDataResult<>(UserViewDto.of(user), Messages.GlobalMessages.DATA_ADDED);
        }
    }

    @Override
    public DataResult<UserViewDto> findByEmail(String email) {
        if(!checkIfUserEmailExists(email)){
            return new ErrorDataResult<>(Messages.UserMessages.USER_EMAIL_NOT_FOUND);
        }
        else{
        User user = this.userRepository.findByEmail(email);
        UserViewDto result = this.modelMapperService.forDto().map(user, UserViewDto.class);
        return new SuccessDataResult<>(result, Messages.UserMessages.USER_LISTED_BY_EMAIL);}
    }

    @Override
    public DataResult<UserViewDto> update(int userId, UserUpdateDto userUpdateDto) {
        if(!checkIfUserIdExists(userId)){
            return new ErrorDataResult<>(Messages.UserMessages.USER_ID_NOT_FOUND);
        }
        else{
            User user = this.userRepository.findByUserId(userId);
            user.setEmail(userUpdateDto.getEmail());
            user.setPassword(userUpdateDto.getPassword());
            this.userRepository.save(user);
            return new SuccessDataResult<>(UserViewDto.of(user), Messages.GlobalMessages.DATA_UPDATED);
        }
    }

    @Override
    public DataResult<UserViewDto> delete(int userId) {
        if(!checkIfUserIdExists(userId)){
            return new ErrorDataResult<>(Messages.UserMessages.USER_ID_NOT_FOUND);
        }
        else{
            User user = this.userRepository.findByUserId(userId);
            this.userRepository.deleteById(userId);
            return new SuccessDataResult<>(UserViewDto.of(user), Messages.GlobalMessages.DATA_DELETED);
        }
    }

    private boolean checkIfUserEmailExists(String email) {
        return this.userRepository.existsByEmail(email);
    }

    private boolean checkIfUserIdExists(int userId) {
        return this.userRepository.existsByUserId(userId);
    }
}
