package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.BrandService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Brand;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NamedStoredProcedureQueries;
import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {

    private BrandService brandService;
    @Autowired
    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/getall")
    public DataResult<List<Brand>> getAll(){
        return this.brandService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        return this.brandService.add(brand);
    }
    @GetMapping("/findbybrandname")
    public DataResult<Brand> findByBrandName(@RequestParam String brandName){
        return this.brandService.findByBrandName(brandName);
    }
    @GetMapping("/findbybrandid")
    public DataResult<Brand> findByBrandId(@RequestParam int brandId){
        return this.brandService.findByBrandId(brandId);
    }
    @GetMapping("/getallbybrandnameasc")
    DataResult<List<Brand>> getAllByBrandNameAsc(){
        return this.brandService.getAllByBrandNameAsc();
    }
    @GetMapping("/getallbybrandnamedesc")
    DataResult<List<Brand>> getAllByBrandNameDesc(){
        return this.brandService.getAllByBrandNameDesc();
    }
}
