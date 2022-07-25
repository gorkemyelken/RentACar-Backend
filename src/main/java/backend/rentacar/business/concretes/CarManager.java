package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CarService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.dataAccess.abstracts.CarDao;
import backend.rentacar.entities.concretes.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarManager implements CarService {

    private CarDao carDao;

    @Autowired
    public CarManager(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public DataResult<List<Car>> getAll() {

        return new SuccessDataResult<>(this.carDao.findAll(),"Cars listed.");
    }

    @Override
    public Result add(Car car) {
        this.carDao.save(car);
        return new SuccessResult("Car added.");
    }

    @Override
    public DataResult<Car> findByCarId(int carId) {
        return new SuccessDataResult<>(this.carDao.findByCarId(carId),"Car listed by id.");
    }

    @Override
    public DataResult<Car> findByCarName(String carName) {
        return new SuccessDataResult<>(this.carDao.findByCarName(carName),"Car listed by name.");
    }

    @Override
    public DataResult<List<Car>> findByDailyPrice(double dailyPrice) {
        return new SuccessDataResult<>(this.carDao.findByDailyPrice(dailyPrice),"Car listed by daily price.");
    }

    @Override
    public DataResult<List<Car>> findByModelYear(int modelYear) {
        return new SuccessDataResult<>(this.carDao.findByModelYear(modelYear),"Car listed by model year.");
    }

    @Override
    public DataResult<List<Car>> findByDailyPriceLessThan(double dailyPrice) {
        return new SuccessDataResult<>(this.carDao.findByDailyPriceLessThan(dailyPrice),"Cars are less than the entered daily price are listed.");
    }

    @Override
    public DataResult<List<Car>> findByDailyPriceGreaterThan(double dailyPrice) {
        return new SuccessDataResult<>(this.carDao.findByDailyPriceGreaterThan(dailyPrice),"Cars are greater than the entered daily price are listed.");
    }

    @Override
    public DataResult<List<Car>> findByDailyPriceBetween(double startDailyPrice, double endDailyPrice) {
        return new SuccessDataResult<>(this.carDao.findByDailyPriceBetween(startDailyPrice, endDailyPrice),"Cars in the entered daily price range are listed.");
    }

    @Override
    public DataResult<List<Car>> findByModelYearLessThan(int modelYear) {
        return new SuccessDataResult<>(this.carDao.findByModelYearLessThan(modelYear),"Cars are less than the entered model year are listed.");
    }

    @Override
    public DataResult<List<Car>> findByModelYearGreaterThan(int modelYear) {
        return new SuccessDataResult<>(this.carDao.findByModelYearGreaterThan(modelYear),"Cars are greater than the entered model year are listed.");
    }

    @Override
    public DataResult<List<Car>> findByModelYearBetween(int startModelYear, int endModelYear) {
        return new SuccessDataResult<>(this.carDao.findByModelYearBetween(startModelYear, endModelYear),"Cars in the entered model year range are listed.");
    }

    @Override
    public DataResult<List<Car>> findByDescriptionContaining(String infix) {
        return new SuccessDataResult<>(this.carDao.findByDescriptionContaining(infix),"Cars matching the description entered are listed.");
    }

    @Override
    public DataResult<List<Car>> findByBrand(int brandId) {
        return new SuccessDataResult<>(this.carDao.findByBrand_BrandId(brandId),"Cars matching the brand entered are listed.");
    }

    @Override
    public DataResult<List<Car>> findByColor(int colorId) {
        return new SuccessDataResult<>(this.carDao.findByColor_ColorId(colorId),"Cars matching the color entered are listed.");
    }
}
