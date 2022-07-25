package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.RentalService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Rental;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rentals")
public class RentalsController {

    private RentalService rentalService;

    @Autowired
    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }
    @GetMapping("/getall")
    DataResult<List<Rental>> getAll(){
        return this.rentalService.getAll();
    }
    @GetMapping("/findbyrentalid")
    public DataResult<Rental> findByRentalId(@RequestParam int rental_id){
        return this.rentalService.findByRentalId(rental_id);
    }
    @PostMapping("/add")
    public Result add(@RequestBody Rental rental){
        return this.rentalService.add(rental);
    }
    @GetMapping("getallbyrentdateasc")
    DataResult<List<Rental>> getAllByRentDateAsc(){
        return this.rentalService.getAllByRentDateAsc();
    }
    @GetMapping("getallbyrentdatedesc")
    DataResult<List<Rental>> getAllByRentDateDesc(){
        return this.rentalService.getAllByRentDateDesc();
    }
    @GetMapping("getallbyreturndateasc")
    DataResult<List<Rental>> getAllByReturnDateAsc(){
        return this.rentalService.getAllByReturnDateAsc();
    }
    @GetMapping("getallbyreturndatedesc")
    DataResult<List<Rental>> getAllByReturnDateDesc(){
        return this.rentalService.getAllByReturnDateDesc();
    }
}
