package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    DataResult<List<Brand>> getAll();
    Result add(Brand brand);
}
