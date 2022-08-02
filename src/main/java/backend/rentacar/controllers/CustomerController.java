package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CustomerService;
import backend.rentacar.entities.concretes.Customer;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getall(){
        return new ResponseEntity<>(this.customerService.getall(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Customer customer){

        return new ResponseEntity(this.customerService.add(customer), HttpStatus.CREATED);
    }
}
