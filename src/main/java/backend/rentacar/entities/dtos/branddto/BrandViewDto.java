package backend.rentacar.entities.dtos.branddto;

import backend.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandViewDto {
    private String brandName;

    public static BrandViewDto of(Brand brand){
        return new BrandViewDto(brand.getBrandName());
    }
}
