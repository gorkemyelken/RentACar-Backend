package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.UserService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.User;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    DataResult<List<User>> getall(){
        return this.userService.getall();
    }
    @PostMapping("/add")
    Result add(@RequestBody User user){
        return this.userService.add(user);
    }
    @GetMapping("/findbyemail")
    DataResult<User> findByEmail(@RequestParam String email){
        return this.userService.findByEmail(email);
    }
}
