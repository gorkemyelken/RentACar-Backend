package backend.rentacar.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import backend.rentacar.business.abstracts.UserService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.ErrorDataResult;
import backend.rentacar.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        return ResponseEntity.ok(this.userService.getall());
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody User user){
        return ResponseEntity.ok(this.userService.add(user));
    }
    @GetMapping("/findbyemail")
    public ResponseEntity<?> findByEmail(@RequestParam String email){
        return ResponseEntity.ok(this.userService.findByEmail(email));
    }



}
