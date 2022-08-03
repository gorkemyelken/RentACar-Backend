package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.CarImageService;
import backend.rentacar.entities.dtos.carimagedto.CarImageCreateDto;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/carimages")
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
        return new ResponseEntity(this.carImageService.add(carImageCreateDto), HttpStatus.CREATED);
    }
}
