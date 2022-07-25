package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.ColorService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Color;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorsController {
    private ColorService colorService;

    @Autowired
    public ColorsController(ColorService colorService) {
        this.colorService = colorService;
    }

    @GetMapping("/getall")
    public DataResult<List<Color>> getAll(){
        return this.colorService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Color color){
        return this.colorService.add(color);
    }
    @GetMapping("/findbycolorname")
    public DataResult<Color> findByColorName(@RequestParam String colorName){
        return this.colorService.findByColorName(colorName);
    }
    @GetMapping("/findbycolorid")
    public DataResult<Color> findByColorId(@RequestParam int colorId){
        return this.colorService.findByColorId(colorId);
    }
    @GetMapping("getallbycolornameasc")
    DataResult<List<Color>> getAllByColorNameAsc(){
        return this.colorService.getAllByColorNameAsc();
    }
    @GetMapping("getallbycolornamedesc")
    DataResult<List<Color>> getAllByColorNameDesc(){
        return this.colorService.getAllByColorNameDesc();
    }
}
