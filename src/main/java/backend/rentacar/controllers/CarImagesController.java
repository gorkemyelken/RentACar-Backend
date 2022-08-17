package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CarImageService;
import backend.rentacar.entities.dtos.carimagedto.CarImageCreateDto;
import backend.rentacar.entities.dtos.carimagedto.CarImageUpdateDto;
import backend.rentacar.entities.dtos.carimagedto.CarImageViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/carimages")
@CrossOrigin
public class CarImagesController {

    private final CarImageService carImageService;

    @Autowired
    public CarImagesController(CarImageService carImageService) {
        this.carImageService = carImageService;
    }

    @GetMapping("/getall")
    public ResponseEntity<CarImageViewDto> getAll(){
        return new ResponseEntity(this.carImageService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<CarImageViewDto> add(@Valid @RequestBody CarImageCreateDto carImageCreateDto){
        return new ResponseEntity(this.carImageService.add(carImageCreateDto), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<CarImageViewDto> update(@RequestParam int carImageId, @Valid @RequestBody CarImageUpdateDto carImageUpdateDto){
        return new ResponseEntity(this.carImageService.update(carImageId, carImageUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<CarImageViewDto> delete(@RequestParam int carImageId){
        return new ResponseEntity(this.carImageService.delete(carImageId), HttpStatus.OK);
    }
    @GetMapping("/findbycarimageid")
    public ResponseEntity<CarImageViewDto> findByCarImageId(@RequestParam int carImageId){
        return new ResponseEntity(this.carImageService.findByCarImageId(carImageId), HttpStatus.OK);
    }
}
