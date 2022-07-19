package backend.rentacar.controllers;

import backend.rentacar.business.abstracts.ColorService;
import backend.rentacar.entities.concretes.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Color> getAll(){
        return this.colorService.getAll();
    }
}
