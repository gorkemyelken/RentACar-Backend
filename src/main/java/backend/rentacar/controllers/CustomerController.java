package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CustomerService;
import backend.rentacar.entities.dtos.customerdto.CustomerCreateDto;
import backend.rentacar.entities.dtos.customerdto.CustomerUpdateDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getall(){
        return new ResponseEntity<>(this.customerService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CustomerCreateDto customerCreateDto){

        return new ResponseEntity<>(this.customerService.add(customerCreateDto), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam int customerId, @Valid @RequestBody CustomerUpdateDto customerUpdateDto){
        return new ResponseEntity<>(this.customerService.update(customerId, customerUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int customerId){
        return new ResponseEntity<>(this.customerService.delete(customerId), HttpStatus.OK);
    }
}
