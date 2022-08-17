package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.ColorService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.colordto.ColorCreateDto;
import backend.rentacar.entities.dtos.colordto.ColorUpdateDto;
import backend.rentacar.entities.dtos.colordto.ColorViewDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/colors")
@CrossOrigin
public class ColorsController {
    private final ColorService colorService;

    @Autowired
    public ColorsController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/getall")
    public ResponseEntity<DataResult<List<ColorViewDto>>> getAll(){
        return new ResponseEntity<>(this.colorService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DataResult<ColorViewDto>> add(@Valid @RequestBody ColorCreateDto colorCreateDto){
        return new ResponseEntity<>(this.colorService.add(colorCreateDto), HttpStatus.CREATED);
    }
    @GetMapping("/findbycolorname")
    public ResponseEntity<DataResult<ColorViewDto>> findByColorName(@RequestParam String colorName){
        return new ResponseEntity<>(this.colorService.findByColorName(colorName), HttpStatus.OK);
    }
    @GetMapping("/findbycolorid")
    public ResponseEntity<DataResult<ColorViewDto>> findByColorId(@RequestParam int colorId){
        return new ResponseEntity<>(this.colorService.findByColorId(colorId), HttpStatus.OK);
    }
    @GetMapping("/getallbycolornameasc")
    public ResponseEntity<DataResult<List<ColorViewDto>>> getAllByColorNameAsc(){
        return new ResponseEntity<>(this.colorService.getAllByColorNameAsc(), HttpStatus.OK);
    }
    @GetMapping("/getallbycolornamedesc")
    public ResponseEntity<DataResult<List<ColorViewDto>>> getAllByColorNameDesc(){
        return new ResponseEntity<>(this.colorService.getAllByColorNameDesc(), HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<DataResult<ColorViewDto>> update(@RequestParam int colorId, @Valid @RequestBody ColorUpdateDto colorUpdateDto){
        return new ResponseEntity<>(this.colorService.update(colorId, colorUpdateDto), HttpStatus.OK);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<DataResult<ColorViewDto>> delete(@RequestParam int colorId){
        return new ResponseEntity<>(this.colorService.delete(colorId), HttpStatus.OK);
    }
}
