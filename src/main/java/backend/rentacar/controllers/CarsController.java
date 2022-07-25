package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CarService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Car;
import backend.rentacar.entities.dtos.CarWithBrandDto;
import backend.rentacar.entities.dtos.CarWithColorDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    private CarService carService;

    @Autowired
    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/getall")
    public DataResult<List<Car>> getAll(){
        return this.carService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Car car){
        return this.carService.add(car);
    }
    @GetMapping("/findbycarid")
    DataResult<Car> findByCarId(@RequestParam int carId){
        return this.carService.findByCarId(carId);
    }
    @GetMapping("/findbycarname")
    DataResult<Car> findByCarName(@RequestParam String carName){
        return this.carService.findByCarName(carName);
    }
    @GetMapping("/findbydailyprice")
    DataResult<List<Car>> findByDailyPrice(@RequestParam double dailyPrice){
        return this.carService.findByDailyPrice(dailyPrice);
    }
    @GetMapping("/findbymodelyear")
    DataResult<List<Car>> findByModelYear(@RequestParam int modelYear){
        return this.carService.findByModelYear(modelYear);
    }
    @GetMapping("/findbydailypricelessthan")
    DataResult<List<Car>> findByDailyPriceLessThan(@RequestParam double dailyPrice){
        return this.carService.findByDailyPriceLessThan(dailyPrice);
    }
    @GetMapping("/findbydailypricegreaterthan")
    DataResult<List<Car>> findByDailyPriceGreaterThan(@RequestParam double dailyPrice){
        return this.carService.findByDailyPriceGreaterThan(dailyPrice);
    }
    @GetMapping("/findbydailypricebetween")
    DataResult<List<Car>> findByDailyPriceBetween(@RequestParam double startDailyPrice,@RequestParam double endDailyPrice){
        return this.carService.findByDailyPriceBetween(startDailyPrice, endDailyPrice);
    }
    @GetMapping("/findbymodelyearlessthan")
    DataResult<List<Car>> findByModelYearLessThan(@RequestParam int modelYear){
        return this.carService.findByModelYearLessThan(modelYear);
    }
    @GetMapping("/findbymodelyeargreaterthan")
    DataResult<List<Car>> findByModelYearGreaterThan(@RequestParam int modelYear){
        return this.carService.findByModelYearGreaterThan(modelYear);
    }
    @GetMapping("/findbymodelyearbetween")
    DataResult<List<Car>> findByModelYearBetween(@RequestParam int startModelYear,@RequestParam int endModelYear){
        return this.carService.findByModelYearBetween(startModelYear, endModelYear);
    }
    @GetMapping("/findbydescriptioncontaining")
    DataResult<List<Car>> findByDescriptionContaining(@RequestParam String infix){
        return this.carService.findByDescriptionContaining(infix);
    }
    @GetMapping("/findbybrand")
    DataResult<List<Car>>  findByBrand(@RequestParam int brandId){
        return this.carService.findByBrand(brandId);
    }
    @GetMapping("/findbycolor")
    DataResult<List<Car>> findByColor(@RequestParam int colorId){
        return this.carService.findByColor(colorId);
    }
    @GetMapping("/getallbypage")
    DataResult<List<Car>> getAll(int pageNo, int pageSize){
        return this.carService.getAll(pageNo, pageSize);
    }
    @GetMapping("/getallsortedbycarnameasc")
    DataResult<List<Car>> getAllSortedByCarNameAsc(){
        return this.carService.getAllSortedByCarNameAsc();
    }
    @GetMapping("/getallsortedbycarnamedesc")
    DataResult<List<Car>> getAllSortedByCarNameDesc(){
        return this.carService.getAllSortedByCarNameDesc();
    }
    @GetMapping("/getallsortedbydailypriceasc")
    DataResult<List<Car>> getAllSortedByDailyPriceAsc(){
        return this.carService.getAllSortedByDailyPriceAsc();
    }
    @GetMapping("/getallsortedbydailypricedesc")
    DataResult<List<Car>> getAllSortedByDailyPriceDesc(){
        return this.carService.getAllSortedByDailyPriceDesc();
    }
    @GetMapping("/getallsortedbymodelyearasc")
    DataResult<List<Car>> getAllSortedByModelYearAsc(){
        return this.carService.getAllSortedByModelYearAsc();
    }
    @GetMapping("/getallsortedbymodelyeardesc")
    DataResult<List<Car>> getAllSortedByModelYearDesc(){
        return this.carService.getAllSortedByModelYearDesc();
    }
    @GetMapping("getcarwithbranddetails")
    DataResult<List<CarWithBrandDto>> getCarWithBrandDetails(){
        return this.carService.getCarWithBrandDetails();
    }
    @GetMapping("getcarwithcolordetails")
    DataResult<List<CarWithColorDto>> getCarWithColorDetails(){
        return this.carService.getCarWithColorDetails();
    }
}
