package backend.rentacar.controllers;

import javax.validation.Valid;

import backend.rentacar.business.abstracts.UserService;
import backend.rentacar.entities.dtos.userdto.UserCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/findbyemail")
    public ResponseEntity<?> findByEmail(@RequestParam String email){
        return new ResponseEntity<>(this.userService.findByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody UserCreateDto userCreateDTO) {
        return new ResponseEntity<>(this.userService.add(userCreateDTO), HttpStatus.CREATED);
    }

}
