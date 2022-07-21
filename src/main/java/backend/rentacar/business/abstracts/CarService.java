package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Car;

import java.util.List;

public interface CarService {
    DataResult<List<Car>> getAll();
    Result add(Car car);
    DataResult<Car> findByCarId(int carId);
    DataResult<Car> findByCarName(String carName);
    DataResult<List<Car>> findByDailyPrice(double dailyPrice);
    DataResult<List<Car>> findByModelYear(int modelYear);
    DataResult<List<Car>> findByDailyPriceLessThan(double dailyPrice);
    DataResult<List<Car>> findByDailyPriceGreaterThan(double dailyPrice);
    DataResult<List<Car>> findByDailyPriceBetween(double startDailyPrice, double endDailyPrice);
    DataResult<List<Car>> findByModelYearLessThan(int modelYear);
    DataResult<List<Car>> findByModelYearGreaterThan(int modelYear);
    DataResult<List<Car>> findByModelYearBetween(int startModelYear, int endModelYear);
    DataResult<List<Car>> findByDescriptionContaining(String infix);
}
