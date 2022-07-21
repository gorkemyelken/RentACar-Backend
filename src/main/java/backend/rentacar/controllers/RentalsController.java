package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.RentalService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Rental;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {

    private RentalService rentalService;

    @Autowired
    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/findbyrentalid")
    public DataResult<Rental> findByRentalId(@RequestParam int rental_id){
        return this.rentalService.findByRentalId(rental_id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Rental rental){
        return this.rentalService.add(rental);
    }
}
