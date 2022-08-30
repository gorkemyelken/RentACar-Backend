package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CarService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.cardto.CarCreateDto;
import backend.rentacar.entities.dtos.cardto.CarUpdateDto;
import backend.rentacar.entities.dtos.cardto.CarViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<DataResult<List<CarViewDto>>> getAll(){
        return new ResponseEntity<>(this.carService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DataResult<CarViewDto>> add(@Valid @RequestBody CarCreateDto carCreateDto){
        return new ResponseEntity<>(this.carService.add(carCreateDto), HttpStatus.CREATED);
    }
    @GetMapping("/findbycarid")
    public ResponseEntity<DataResult<CarViewDto>> findByCarId(@RequestParam int carId){
        return new ResponseEntity<>(this.carService.findByCarId(carId), HttpStatus.OK);
    }
    @GetMapping("/findbycarname")
    public ResponseEntity<DataResult<CarViewDto>> findByCarName(@RequestParam String carName){
        return new ResponseEntity<>(this.carService.findByCarName(carName), HttpStatus.OK);
    }
    @GetMapping("/findbydailyprice")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByDailyPrice(@RequestParam double dailyPrice){
        return new ResponseEntity<>(this.carService.findByDailyPrice(dailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyear")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByModelYear(@RequestParam int modelYear){
        return new ResponseEntity<>(this.carService.findByModelYear(modelYear), HttpStatus.OK);
    }
    @GetMapping("/findbydailypricelessthan")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByDailyPriceLessThan(@RequestParam double dailyPrice){
        return new ResponseEntity<>(this.carService.findByDailyPriceLessThan(dailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbydailypricegreaterthan")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByDailyPriceGreaterThan(@RequestParam double dailyPrice){
        return new ResponseEntity<>(this.carService.findByDailyPriceGreaterThan(dailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbydailypricebetween")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByDailyPriceBetween(@RequestParam double startDailyPrice,@RequestParam double endDailyPrice){
        return new ResponseEntity<>(this.carService.findByDailyPriceBetween(startDailyPrice, endDailyPrice), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyearlessthan")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByModelYearLessThan(@RequestParam int modelYear){
        return new ResponseEntity<>(this.carService.findByModelYearLessThan(modelYear), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyeargreaterthan")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByModelYearGreaterThan(@RequestParam int modelYear){
        return new ResponseEntity<>(this.carService.findByModelYearGreaterThan(modelYear), HttpStatus.OK);
    }
    @GetMapping("/findbymodelyearbetween")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByModelYearBetween(@RequestParam int startModelYear,@RequestParam int endModelYear){
        return new ResponseEntity<>(this.carService.findByModelYearBetween(startModelYear, endModelYear), HttpStatus.OK);
    }
    @GetMapping("/findbydescriptioncontaining")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByDescriptionContaining(@RequestParam String infix){
        return new ResponseEntity<>(this.carService.findByDescriptionContaining(infix), HttpStatus.OK);
    }
    @GetMapping("/findbybrand")
    public ResponseEntity<DataResult<List<CarViewDto>>>  findByBrand(@RequestParam int brandId){
        return new ResponseEntity<>(this.carService.findByBrand(brandId), HttpStatus.OK);
    }
    @GetMapping("/findbycolor")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByColor(@RequestParam int colorId){
        return new ResponseEntity<>(this.carService.findByColor(colorId), HttpStatus.OK);
    }
    @GetMapping("/getallbypage")
    public ResponseEntity<DataResult<List<CarViewDto>>> getAll(int pageNo, int pageSize){
        return new ResponseEntity<>(this.carService.getAll(pageNo, pageSize), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbycarnameasc")
    public ResponseEntity<DataResult<List<CarViewDto>>> getAllSortedByCarNameAsc(){
        return new ResponseEntity<>(this.carService.getAllSortedByCarNameAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbycarnamedesc")
    public ResponseEntity<DataResult<List<CarViewDto>>> getAllSortedByCarNameDesc(){
        return new ResponseEntity<>(this.carService.getAllSortedByCarNameDesc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbydailypriceasc")
    public ResponseEntity<DataResult<List<CarViewDto>>> getAllSortedByDailyPriceAsc(){
        return new ResponseEntity<>(this.carService.getAllSortedByDailyPriceAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbydailypricedesc")
    public ResponseEntity<DataResult<List<CarViewDto>>> getAllSortedByDailyPriceDesc(){
        return new ResponseEntity<>(this.carService.getAllSortedByDailyPriceDesc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbymodelyearasc")
    public ResponseEntity<DataResult<List<CarViewDto>>> getAllSortedByModelYearAsc(){
        return new ResponseEntity<>(this.carService.getAllSortedByModelYearAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallsortedbymodelyeardesc")
    public ResponseEntity<DataResult<List<CarViewDto>>> getAllSortedByModelYearDesc(){
        return new ResponseEntity<>(this.carService.getAllSortedByModelYearDesc(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<DataResult<CarViewDto>> update(@RequestParam int carId, @Valid @RequestBody CarUpdateDto carUpdateDto){
        return new ResponseEntity<>(this.carService.update(carId, carUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DataResult<CarViewDto>> delete(@RequestParam int carId){
        return new ResponseEntity<>(this.carService.delete(carId), HttpStatus.OK);
    }

    @GetMapping("/findbyfiltered")
    public ResponseEntity<DataResult<List<CarViewDto>>> findByFiltered(@RequestParam(value = "brandId") int brandId,
                                                                       @RequestParam(value = "colorId") int colorId,
                                                                       @RequestParam(value = "startModelYear") int startModelYear,
                                                                       @RequestParam(value = "endModelYear") int endModelYear ,
                                                                       @RequestParam(value = "startDailyPrice") double startDailyPrice,
                                                                       @RequestParam(value = "endDailyPrice") double endDailyPrice){
        return new ResponseEntity<>(this.carService.findByFiltered(brandId, colorId, startModelYear, endModelYear, startDailyPrice, endDailyPrice), HttpStatus.OK);}
}