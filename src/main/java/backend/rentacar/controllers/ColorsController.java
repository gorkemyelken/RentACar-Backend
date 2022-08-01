package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.ColorService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Color;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {
    private final ColorService colorService;

    @Autowired
    public ColorsController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.colorService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Color color){
        return new ResponseEntity(this.colorService.add(color), HttpStatus.CREATED);
    }
    @GetMapping("/findbycolorname")
    public ResponseEntity<?> findByColorName(@RequestParam String colorName){
        return new ResponseEntity<>(this.colorService.findByColorName(colorName), HttpStatus.OK);
    }
    @GetMapping("/findbycolorid")
    public ResponseEntity<?> findByColorId(@RequestParam int colorId){
        return new ResponseEntity<>(this.colorService.findByColorId(colorId), HttpStatus.OK);
    }
    @GetMapping("getallbycolornameasc")
    public ResponseEntity<?> getAllByColorNameAsc(){
        return new ResponseEntity<>(this.colorService.getAllByColorNameAsc(), HttpStatus.OK);
    }
    @GetMapping("getallbycolornamedesc")
    public ResponseEntity<?> getAllByColorNameDesc(){
        return new ResponseEntity<>(this.colorService.getAllByColorNameDesc(), HttpStatus.OK);
    }
}
