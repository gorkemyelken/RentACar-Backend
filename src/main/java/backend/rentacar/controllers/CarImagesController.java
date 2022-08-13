package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CarImageService;
import backend.rentacar.entities.dtos.carimagedto.CarImageCreateDto;
import backend.rentacar.entities.dtos.carimagedto.CarImageUpdateDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
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
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.carImageService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CarImageCreateDto carImageCreateDto){
        return new ResponseEntity<>(this.carImageService.add(carImageCreateDto), HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestParam int carImageId, @Valid @RequestBody CarImageUpdateDto carImageUpdateDto){
        return new ResponseEntity<>(this.carImageService.update(carImageId, carImageUpdateDto), HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam int carImageId){
        return new ResponseEntity<>(this.carImageService.delete(carImageId), HttpStatus.OK);
    }
}
