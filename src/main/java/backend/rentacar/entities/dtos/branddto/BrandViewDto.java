package backend.rentacar.entities.dtos.branddto;

import backend.rentacar.entities.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BrandViewDto {
    private int brandId;

    private String brandName;

    private String brandImagePath;
    public static BrandViewDto of(Brand brand){
        return new BrandViewDto(brand.getBrandId(), brand.getBrandName(), brand.getBrandImagePath());
    }
}
