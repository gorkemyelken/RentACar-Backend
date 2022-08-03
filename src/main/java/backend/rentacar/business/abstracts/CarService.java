package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.cardto.CarCreateDto;
import backend.rentacar.entities.dtos.cardto.CarViewDto;

import java.util.List;

public interface CarService {
    DataResult<List<CarViewDto>> getAll();
    DataResult<List<CarViewDto>> getAll(int pageNo, int pageSize);
    DataResult<List<CarViewDto>> getAllSortedByCarNameAsc();
    DataResult<List<CarViewDto>> getAllSortedByCarNameDesc();
    DataResult<List<CarViewDto>> getAllSortedByDailyPriceAsc();
    DataResult<List<CarViewDto>> getAllSortedByDailyPriceDesc();
    DataResult<List<CarViewDto>> getAllSortedByModelYearAsc();
    DataResult<List<CarViewDto>> getAllSortedByModelYearDesc();
    DataResult<CarViewDto> add(CarCreateDto carCreateDto);
    DataResult<CarViewDto> findByCarId(int carId);
    DataResult<CarViewDto> findByCarName(String carName);
    DataResult<List<CarViewDto>> findByDailyPrice(double dailyPrice);
    DataResult<List<CarViewDto>> findByModelYear(int modelYear);
    DataResult<List<CarViewDto>> findByDailyPriceLessThan(double dailyPrice);
    DataResult<List<CarViewDto>> findByDailyPriceGreaterThan(double dailyPrice);
    DataResult<List<CarViewDto>> findByDailyPriceBetween(double startDailyPrice, double endDailyPrice);
    DataResult<List<CarViewDto>> findByModelYearLessThan(int modelYear);
    DataResult<List<CarViewDto>> findByModelYearGreaterThan(int modelYear);
    DataResult<List<CarViewDto>> findByModelYearBetween(int startModelYear, int endModelYear);
    DataResult<List<CarViewDto>> findByDescriptionContaining(String infix);
    DataResult<List<CarViewDto>>  findByBrand(int brandId);
    DataResult<List<CarViewDto>> findByColor(int colorId);
}
