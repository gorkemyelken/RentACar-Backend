package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.RentalService;
import backend.rentacar.entities.dtos.rentaldto.RentalCreateDto;
import backend.rentacar.entities.dtos.rentaldto.RentalUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.rentalService.getAll(), HttpStatus.OK);
    }
    @GetMapping("/findbyrentalid")
    public ResponseEntity<?> findByRentalId(@RequestParam int rental_id){
        return new ResponseEntity<>(this.rentalService.findByRentalId(rental_id), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody RentalCreateDto rentalCreateDto){
        return new ResponseEntity<>(this.rentalService.add(rentalCreateDto), HttpStatus.CREATED);
    }
    @GetMapping("getallbyrentdateasc")
    ResponseEntity<?> getAllByRentDateAsc(){
        return new ResponseEntity<>(this.rentalService.getAllByRentDateAsc(), HttpStatus.OK);
    }
    @GetMapping("getallbyrentdatedesc")
    ResponseEntity<?> getAllByRentDateDesc(){
        return new ResponseEntity<>(this.rentalService.getAllByRentDateDesc(), HttpStatus.OK);
    }
    @GetMapping("getallbyreturndateasc")
    ResponseEntity<?> getAllByReturnDateAsc(){
        return new ResponseEntity<>(this.rentalService.getAllByReturnDateAsc(), HttpStatus.OK);
    }
    @GetMapping("getallbyreturndatedesc")
    ResponseEntity<?> getAllByReturnDateDesc(){
        return new ResponseEntity<>(this.rentalService.getAllByReturnDateDesc(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam int rentalId, @Valid @RequestBody RentalUpdateDto rentalUpdateDto){
        return new ResponseEntity<>(this.rentalService.update(rentalId, rentalUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int rentalId){
        return new ResponseEntity<>(this.rentalService.delete(rentalId), HttpStatus.OK);
    }
}