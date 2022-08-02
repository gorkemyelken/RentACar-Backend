package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.concretes.Brand;
import backend.rentacar.entities.concretes.CarImage;

import java.util.List;

public interface CarImageService {
    DataResult<List<CarImage>> getAll();
}
