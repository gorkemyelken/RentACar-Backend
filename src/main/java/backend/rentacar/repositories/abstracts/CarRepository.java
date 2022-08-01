package backend.rentacar.repositories.abstracts;

import backend.rentacar.entities.concretes.Car;
import backend.rentacar.entities.dtos.CarWithBrandDto;
import backend.rentacar.entities.dtos.CarWithColorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
    @Query("select new backend.rentacar.entities.dtos.CarWithBrandDto(c.carId, c.carName, b.brandName) from Brand b inner join b.cars c")
    List<CarWithBrandDto> getCarWithBrandDetails();
    @Query("select new backend.rentacar.entities.dtos.CarWithColorDto(c.carId, c.carName, co.colorName) from Color co inner join co.cars c")
    List<CarWithColorDto> getCarWithColorDetails();
}
