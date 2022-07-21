package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.RentalService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.concretes.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
