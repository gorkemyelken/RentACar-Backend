package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.BrandService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.branddto.BrandCreateDto;
import backend.rentacar.entities.dtos.branddto.BrandUpdateDto;
import backend.rentacar.entities.dtos.branddto.BrandViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public ResponseEntity<DataResult<List<BrandViewDto>>> getAll(){
        return new ResponseEntity<>(this.brandService.getAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<DataResult<BrandViewDto>> add(@Valid @RequestBody BrandCreateDto brandCreateDto){
        return new ResponseEntity<>(this.brandService.add(brandCreateDto),HttpStatus.CREATED);
    }
    @GetMapping("/findbybrandname")
    public ResponseEntity<DataResult<BrandViewDto>> findByBrandName(@RequestParam String brandName){
        return new ResponseEntity<>(this.brandService.findByBrandName(brandName), HttpStatus.OK);
    }
    @GetMapping("/findbybrandid")
    public ResponseEntity<DataResult<BrandViewDto>> findByBrandId(@RequestParam int brandId){
        return new ResponseEntity<>(this.brandService.findByBrandId(brandId), HttpStatus.OK);
    }
    @GetMapping("/getallbybrandnameasc")
    public ResponseEntity<DataResult<List<BrandViewDto>>> getAllByBrandNameAsc(){
        return new ResponseEntity<>(this.brandService.getAllByBrandNameAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallbybrandnamedesc")
    public ResponseEntity<DataResult<List<BrandViewDto>>> getAllByBrandNameDesc(){
        return new ResponseEntity<>(this.brandService.getAllByBrandNameDesc(), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<DataResult<BrandViewDto>> update(@RequestParam int brandId, @Valid @RequestBody BrandUpdateDto brandUpdateDto){
        return new ResponseEntity<>(this.brandService.update(brandId, brandUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<DataResult<BrandViewDto>> delete(@RequestParam int brandId){
        return new ResponseEntity<>(this.brandService.delete(brandId), HttpStatus.OK);
    }
}
