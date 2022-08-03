package backend.rentacar.entities.dtos.branddto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandCreateDto {
    @NotNull
    @UniqueElements
    private String brandName;
}
