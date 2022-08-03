package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.branddto.BrandCreateDto;
import backend.rentacar.entities.dtos.branddto.BrandViewDto;

import java.util.List;

public interface BrandService {
    DataResult<List<BrandViewDto>> getAll();
    DataResult<List<BrandViewDto>> getAllByBrandNameAsc();
    DataResult<List<BrandViewDto>> getAllByBrandNameDesc();
    DataResult<BrandViewDto> add(BrandCreateDto brandCreateDto);
    DataResult<BrandViewDto> findByBrandId(int brandId);
    DataResult<BrandViewDto> findByBrandName(String brandName);
}
