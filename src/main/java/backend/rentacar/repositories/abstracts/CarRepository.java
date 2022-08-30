package backend.rentacar.repositories.abstracts;

import backend.rentacar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface CarRepository extends JpaRepository<Car,Integer> {
    Car findByCarId(int carId);
    Car findByCarName(String carName);
    List<Car> findByDailyPrice(double dailyPrice);
    List<Car> findByModelYear(int modelYear);
    List<Car> findByDailyPriceLessThan(double dailyPrice);
    List<Car> findByDailyPriceGreaterThan(double dailyPrice);
    List<Car> findByDailyPriceBetween(double startDailyPrice, double endDailyPrice);
    List<Car> findByModelYearLessThan(int modelYear);
    List<Car> findByModelYearGreaterThan(int modelYear);
    List<Car> findByModelYearBetween(int startModelYear, int endModelYear);
    List<Car> findByDescriptionContaining(String infix);
    List<Car> findByBrand_BrandId(int brandId);
    List<Car> findByColor_ColorId(int colorId);
    boolean existsByCarId(int carId);
    boolean existsByCarName(String carName);
    List<Car> findByBrand_BrandIdAndColor_ColorIdAndModelYearBetweenAndDailyPriceBetween(int brandId, int colorId, int startModelYear, int endModelYear, double startDailyPrice, double endDailyPrice);
}
