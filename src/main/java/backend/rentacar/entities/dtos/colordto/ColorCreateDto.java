package backend.rentacar.entities.dtos.colordto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ColorCreateDto {
    @NotNull
    @UniqueElements
    private String colorName;
}
