package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CarService;
import backend.rentacar.entities.dtos.cardto.CarCreateDto;
import backend.rentacar.entities.dtos.cardto.CarUpdateDto;
import backend.rentacar.entities.dtos.cardto.CarViewDto;
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
    public ResponseEntity<CarViewDto> getAll(){
        return new ResponseEntity(this.carService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<CarViewDto> add(@Valid @RequestBody CarCreateDto carCreateDto){
        return new ResponseEntity(this.carService.add(carCreateDto), HttpStatus.CREATED);
    }
    @GetMapping("/findbycarid")
    public ResponseEntity<CarViewDto> findByCarId(@RequestParam int carId){
        return new ResponseEntity(this.carService.findByCarId(carId), HttpStatus.OK);
    }
    @GetMapping("/findbycarname")
    public ResponseEntity<CarViewDto> findByCarName(@RequestParam String carName){
        return new ResponseEntity(this.carService.findByCarName(carName), HttpStatus.OK);
    }
    @GetMapping("/findbydailyprice")
    public ResponseEntity<CarViewDto> findByDailyPrice(@RequestParam double dailyPrice){
        return new ResponseEntity(this.carService.findByDailyPrice(dailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyear")
    public ResponseEntity<CarViewDto> findByModelYear(@RequestParam int modelYear){
        return new ResponseEntity(this.carService.findByModelYear(modelYear), HttpStatus.OK);
    }
    @GetMapping("/findbydailypricelessthan")
    public ResponseEntity<CarViewDto> findByDailyPriceLessThan(@RequestParam double dailyPrice){
        return new ResponseEntity(this.carService.findByDailyPriceLessThan(dailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbydailypricegreaterthan")
    public ResponseEntity<CarViewDto> findByDailyPriceGreaterThan(@RequestParam double dailyPrice){
        return new ResponseEntity(this.carService.findByDailyPriceGreaterThan(dailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbydailypricebetween")
    public ResponseEntity<CarViewDto> findByDailyPriceBetween(@RequestParam double startDailyPrice,@RequestParam double endDailyPrice){
        return new ResponseEntity(this.carService.findByDailyPriceBetween(startDailyPrice, endDailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyearlessthan")
    public ResponseEntity<CarViewDto> findByModelYearLessThan(@RequestParam int modelYear){
        return new ResponseEntity(this.carService.findByModelYearLessThan(modelYear), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyeargreaterthan")
    public ResponseEntity<CarViewDto> findByModelYearGreaterThan(@RequestParam int modelYear){
        return new ResponseEntity(this.carService.findByModelYearGreaterThan(modelYear), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyearbetween")
    public ResponseEntity<CarViewDto> findByModelYearBetween(@RequestParam int startModelYear,@RequestParam int endModelYear){
        return new ResponseEntity(this.carService.findByModelYearBetween(startModelYear, endModelYear), HttpStatus.OK);
    }
    @GetMapping("/findbydescriptioncontaining")
    public ResponseEntity<CarViewDto> findByDescriptionContaining(@RequestParam String infix){
        return new ResponseEntity(this.carService.findByDescriptionContaining(infix), HttpStatus.OK);
    }
    @GetMapping("/findbybrand")
    public ResponseEntity<CarViewDto>  findByBrand(@RequestParam int brandId){
        return new ResponseEntity(this.carService.findByBrand(brandId), HttpStatus.OK);
    }
    @GetMapping("/findbycolor")
    public ResponseEntity<CarViewDto> findByColor(@RequestParam int colorId){
        return new ResponseEntity(this.carService.findByColor(colorId), HttpStatus.OK);
    }
    @GetMapping("/getallbypage")
    public ResponseEntity<CarViewDto> getAll(int pageNo, int pageSize){
        return new ResponseEntity(this.carService.getAll(pageNo, pageSize), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbycarnameasc")
    public ResponseEntity<CarViewDto> getAllSortedByCarNameAsc(){
        return new ResponseEntity(this.carService.getAllSortedByCarNameAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbycarnamedesc")
    public ResponseEntity<CarViewDto> getAllSortedByCarNameDesc(){
        return new ResponseEntity(this.carService.getAllSortedByCarNameDesc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbydailypriceasc")
    public ResponseEntity<CarViewDto> getAllSortedByDailyPriceAsc(){
        return new ResponseEntity(this.carService.getAllSortedByDailyPriceAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbydailypricedesc")
    public ResponseEntity<CarViewDto> getAllSortedByDailyPriceDesc(){
        return new ResponseEntity(this.carService.getAllSortedByDailyPriceDesc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbymodelyearasc")
    public ResponseEntity<CarViewDto> getAllSortedByModelYearAsc(){
        return new ResponseEntity(this.carService.getAllSortedByModelYearAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbymodelyeardesc")
    public ResponseEntity<CarViewDto> getAllSortedByModelYearDesc(){
        return new ResponseEntity(this.carService.getAllSortedByModelYearDesc(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<CarViewDto> update(@RequestParam int carId, @Valid @RequestBody CarUpdateDto carUpdateDto){
        return new ResponseEntity(this.carService.update(carId, carUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CarViewDto> delete(@RequestParam int carId){
        return new ResponseEntity(this.carService.delete(carId), HttpStatus.OK);
    }
}