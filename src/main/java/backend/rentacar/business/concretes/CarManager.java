package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CarService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.dataAccess.abstracts.CarDao;
import backend.rentacar.entities.concretes.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public DataResult<List<Car>> getAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1,pageSize);
        return new SuccessDataResult<List<Car>>(this.carDao.findAll(pageable).getContent());
    }

    @Override
    public DataResult<List<Car>> getAllSortedByCarNameAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"carName");
        return new SuccessDataResult<List<Car>>(this.carDao.findAll(sort),"The cars were sorted in ascending alphabet of the car name.");
    }

    @Override
    public DataResult<List<Car>> getAllSortedByCarNameDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"carName");
        return new SuccessDataResult<List<Car>>(this.carDao.findAll(sort),"The cars were sorted in descending alphabet of the car name.");
    }

    @Override
    public DataResult<List<Car>> getAllSortedByDailyPriceAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"dailyPrice");
        return new SuccessDataResult<List<Car>>(this.carDao.findAll(sort),"The cars were sorted in ascending of the daily price.");
    }

    @Override
    public DataResult<List<Car>> getAllSortedByDailyPriceDesc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"dailyPrice");
        return new SuccessDataResult<List<Car>>(this.carDao.findAll(sort),"The cars were sorted in descending of the daily price.");
    }

    @Override
    public DataResult<List<Car>> getAllSortedByModelYearAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"modelYear");
        return new SuccessDataResult<List<Car>>(this.carDao.findAll(sort),"The cars were sorted in ascending of the model year.");
    }

    @Override
    public DataResult<List<Car>> getAllSortedByModelYearDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"modelYear");
        return new SuccessDataResult<List<Car>>(this.carDao.findAll(sort),"The cars were sorted in descending alphabet of the model year.");
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
