package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    DataResult<List<Brand>> getAll();
    DataResult<List<Brand>> getAllByBrandNameAsc();
    DataResult<List<Brand>> getAllByBrandNameDesc();
    Result add(Brand brand);
    DataResult<Brand> findByBrandId(int brandId);
    DataResult<Brand> findByBrandName(String brandName);
}
