package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Car;

import java.util.List;

public interface CarService {
    DataResult<List<Car>> getAll();

    Result add(Car car);
}
