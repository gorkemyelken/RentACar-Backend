package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.RentalService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.rentaldto.RentalCreateDto;
import backend.rentacar.entities.dtos.rentaldto.RentalUpdateDto;
import backend.rentacar.entities.dtos.rentaldto.RentalViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/rentals")
@CrossOrigin
public class RentalsController {

    private final RentalService rentalService;

    @Autowired
    public RentalsController(RentalService rentalService) {
        this.rentalService = rentalService;
    }
    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<RentalViewDto>>> getAll(){
        return new ResponseEntity<>(this.rentalService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/findbyrentalid")
    public ResponseEntity<DataResult<RentalViewDto>> findByRentalId(@RequestParam int rental_id){
        return new ResponseEntity<>(this.rentalService.findByRentalId(rental_id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DataResult<RentalViewDto>> add(@Valid @RequestBody RentalCreateDto rentalCreateDto){
        return new ResponseEntity<>(this.rentalService.add(rentalCreateDto), HttpStatus.CREATED);
    }
    @GetMapping("/getallbyrentdateasc")
    ResponseEntity<DataResult<List<RentalViewDto>>> getAllByRentDateAsc(){
        return new ResponseEntity<>(this.rentalService.getAllByRentDateAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallbyrentdatedesc")
    ResponseEntity<DataResult<List<RentalViewDto>>> getAllByRentDateDesc(){
        return new ResponseEntity<>(this.rentalService.getAllByRentDateDesc(), HttpStatus.OK);
    }
    @GetMapping("/getallbyreturndateasc")
    ResponseEntity<DataResult<List<RentalViewDto>>> getAllByReturnDateAsc(){
        return new ResponseEntity<>(this.rentalService.getAllByReturnDateAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallbyreturndatedesc")
    ResponseEntity<DataResult<List<RentalViewDto>>> getAllByReturnDateDesc(){
        return new ResponseEntity<>(this.rentalService.getAllByReturnDateDesc(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<DataResult<RentalViewDto>> update(@RequestParam int rentalId, @Valid @RequestBody RentalUpdateDto rentalUpdateDto){
        return new ResponseEntity<>(this.rentalService.update(rentalId, rentalUpdateDto), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<DataResult<RentalViewDto>> delete(@RequestParam int rentalId){
        return new ResponseEntity<>(this.rentalService.delete(rentalId), HttpStatus.OK);
    }
}