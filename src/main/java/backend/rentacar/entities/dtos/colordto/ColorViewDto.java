package backend.rentacar.entities.dtos.colordto;

import backend.rentacar.entities.concretes.Color;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColorViewDto {
    private String colorName;

    public static ColorViewDto of(Color color){
        return new ColorViewDto(color.getColorName());
    }
}
