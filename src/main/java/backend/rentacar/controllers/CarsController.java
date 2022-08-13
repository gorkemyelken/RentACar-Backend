package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CarService;
import backend.rentacar.entities.dtos.cardto.CarCreateDto;
import backend.rentacar.entities.dtos.cardto.CarUpdateDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cars")
@CrossOrigin
public class CarsController {
    private final CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.carService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CarCreateDto carCreateDto){
        return new ResponseEntity<>(this.carService.add(carCreateDto), HttpStatus.CREATED);
    }
    @GetMapping("/findbycarid")
    public ResponseEntity<?> findByCarId(@RequestParam int carId){
        return new ResponseEntity<>(this.carService.findByCarId(carId), HttpStatus.OK);
    }
    @GetMapping("/findbycarname")
    public ResponseEntity<?> findByCarName(@RequestParam String carName){
        return new ResponseEntity<>(this.carService.findByCarName(carName), HttpStatus.OK);
    }
    @GetMapping("/findbydailyprice")
    public ResponseEntity<?> findByDailyPrice(@RequestParam double dailyPrice){
        return new ResponseEntity<>(this.carService.findByDailyPrice(dailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyear")
    public ResponseEntity<?> findByModelYear(@RequestParam int modelYear){
        return new ResponseEntity<>(this.carService.findByModelYear(modelYear), HttpStatus.OK);
    }
    @GetMapping("/findbydailypricelessthan")
    public ResponseEntity<?> findByDailyPriceLessThan(@RequestParam double dailyPrice){
        return new ResponseEntity<>(this.carService.findByDailyPriceLessThan(dailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbydailypricegreaterthan")
    public ResponseEntity<?> findByDailyPriceGreaterThan(@RequestParam double dailyPrice){
        return new ResponseEntity<>(this.carService.findByDailyPriceGreaterThan(dailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbydailypricebetween")
    public ResponseEntity<?> findByDailyPriceBetween(@RequestParam double startDailyPrice,@RequestParam double endDailyPrice){
        return new ResponseEntity<>(this.carService.findByDailyPriceBetween(startDailyPrice, endDailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyearlessthan")
    public ResponseEntity<?> findByModelYearLessThan(@RequestParam int modelYear){
        return new ResponseEntity<>(this.carService.findByModelYearLessThan(modelYear), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyeargreaterthan")
    public ResponseEntity<?> findByModelYearGreaterThan(@RequestParam int modelYear){
        return new ResponseEntity<>(this.carService.findByModelYearGreaterThan(modelYear), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyearbetween")
    public ResponseEntity<?> findByModelYearBetween(@RequestParam int startModelYear,@RequestParam int endModelYear){
        return new ResponseEntity<>(this.carService.findByModelYearBetween(startModelYear, endModelYear), HttpStatus.OK);
    }
    @GetMapping("/findbydescriptioncontaining")
    public ResponseEntity<?> findByDescriptionContaining(@RequestParam String infix){
        return new ResponseEntity<>(this.carService.findByDescriptionContaining(infix), HttpStatus.OK);
    }
    @GetMapping("/findbybrand")
    public ResponseEntity<?>  findByBrand(@RequestParam int brandId){
        return new ResponseEntity<>(this.carService.findByBrand(brandId), HttpStatus.OK);
    }
    @GetMapping("/findbycolor")
    public ResponseEntity<?> findByColor(@RequestParam int colorId){
        return new ResponseEntity<>(this.carService.findByColor(colorId), HttpStatus.OK);
    }
    @GetMapping("/getallbypage")
    public ResponseEntity<?> getAll(int pageNo, int pageSize){
        return new ResponseEntity<>(this.carService.getAll(pageNo, pageSize), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbycarnameasc")
    public ResponseEntity<?> getAllSortedByCarNameAsc(){
        return new ResponseEntity<>(this.carService.getAllSortedByCarNameAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbycarnamedesc")
    public ResponseEntity<?> getAllSortedByCarNameDesc(){
        return new ResponseEntity<>(this.carService.getAllSortedByCarNameDesc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbydailypriceasc")
    public ResponseEntity<?> getAllSortedByDailyPriceAsc(){
        return new ResponseEntity<>(this.carService.getAllSortedByDailyPriceAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbydailypricedesc")
    public ResponseEntity<?> getAllSortedByDailyPriceDesc(){
        return new ResponseEntity<>(this.carService.getAllSortedByDailyPriceDesc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbymodelyearasc")
    public ResponseEntity<?> getAllSortedByModelYearAsc(){
        return new ResponseEntity<>(this.carService.getAllSortedByModelYearAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbymodelyeardesc")
    public ResponseEntity<?> getAllSortedByModelYearDesc(){
        return new ResponseEntity<>(this.carService.getAllSortedByModelYearDesc(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam int carId, @Valid @RequestBody CarUpdateDto carUpdateDto){
        return new ResponseEntity<>(this.carService.update(carId, carUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int carId){
        return new ResponseEntity<>(this.carService.delete(carId), HttpStatus.OK);
    }
}