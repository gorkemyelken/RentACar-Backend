package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.BrandService;
import backend.rentacar.entities.dtos.branddto.BrandCreateDto;
import backend.rentacar.entities.dtos.branddto.BrandUpdateDto;
import backend.rentacar.entities.dtos.branddto.BrandViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/brands")
@CrossOrigin
public class BrandsController {

    private final BrandService brandService;
    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public ResponseEntity<BrandViewDto> getAll(){
        return new ResponseEntity(this.brandService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<BrandViewDto> add(@Valid @RequestBody BrandCreateDto brandCreateDto){
        return new ResponseEntity(this.brandService.add(brandCreateDto),HttpStatus.CREATED);
    }
    @GetMapping("/findbybrandname")
    public ResponseEntity<BrandViewDto> findByBrandName(@RequestParam String brandName){
        return new ResponseEntity(this.brandService.findByBrandName(brandName), HttpStatus.OK);
    }
    @GetMapping("/findbybrandid")
    public ResponseEntity<BrandViewDto> findByBrandId(@RequestParam int brandId){
        return new ResponseEntity(this.brandService.findByBrandId(brandId), HttpStatus.OK);
    }
    @GetMapping("/getallbybrandnameasc")
    public ResponseEntity<BrandViewDto> getAllByBrandNameAsc(){
        return new ResponseEntity(this.brandService.getAllByBrandNameAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallbybrandnamedesc")
    public ResponseEntity<BrandViewDto> getAllByBrandNameDesc(){
        return new ResponseEntity(this.brandService.getAllByBrandNameDesc(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<BrandViewDto> update(@RequestParam int brandId, @Valid @RequestBody BrandUpdateDto brandUpdateDto){
        return new ResponseEntity(this.brandService.update(brandId, brandUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BrandViewDto> delete(@RequestParam int brandId){
        return new ResponseEntity(this.brandService.delete(brandId), HttpStatus.OK);
    }
}
