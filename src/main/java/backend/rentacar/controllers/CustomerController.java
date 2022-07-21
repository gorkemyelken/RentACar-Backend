package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CustomerService;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Customer;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Customer customer){
        return this.customerService.add(customer);
    }
}
