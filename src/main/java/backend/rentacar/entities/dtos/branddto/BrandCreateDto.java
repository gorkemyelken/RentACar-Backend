package backend.rentacar.entities.dtos.branddto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandCreateDto {
    @NotNull
    private String brandName;
}
