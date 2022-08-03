package backend.rentacar.entities.dtos.carimagedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarImageUpdateDto {
    @NotNull
    @UniqueElements
    private String imagePath;
}
