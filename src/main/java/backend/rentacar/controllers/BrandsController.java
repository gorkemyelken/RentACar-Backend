package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.BrandService;
import backend.rentacar.entities.concretes.Brand;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private final BrandService brandService;
    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.brandService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity add(@Valid @RequestBody Brand brand){
        return new ResponseEntity(this.brandService.add(brand),HttpStatus.CREATED);
    }
    @GetMapping("/findbybrandname")
    public ResponseEntity<?> findByBrandName(@RequestParam String brandName){
        return new ResponseEntity<>(this.brandService.findByBrandName(brandName), HttpStatus.OK);
    }
    @GetMapping("/findbybrandid")
    public ResponseEntity<?> findByBrandId(@RequestParam int brandId){
        return new ResponseEntity<>(this.brandService.findByBrandId(brandId), HttpStatus.OK);
    }
    @GetMapping("/getallbybrandnameasc")
    public ResponseEntity<?> getAllByBrandNameAsc(){
        return new ResponseEntity<>(this.brandService.getAllByBrandNameAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallbybrandnamedesc")
    public ResponseEntity<?> getAllByBrandNameDesc(){
        return new ResponseEntity<>(this.brandService.getAllByBrandNameDesc(), HttpStatus.OK);
    }
}
