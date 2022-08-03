package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Rental;
import backend.rentacar.entities.dtos.rentaldto.RentalCreateDto;
import backend.rentacar.entities.dtos.rentaldto.RentalViewDto;

import java.util.List;

public interface RentalService {
    DataResult<List<RentalViewDto>> getAll();
    DataResult<RentalViewDto> findByRentalId(int rentalId);
    DataResult<RentalViewDto> add(RentalCreateDto rentalCreateDto);
    DataResult<List<RentalViewDto>> getAllByRentDateAsc();
    DataResult<List<RentalViewDto>> getAllByRentDateDesc();
    DataResult<List<RentalViewDto>> getAllByReturnDateAsc();
    DataResult<List<RentalViewDto>> getAllByReturnDateDesc();
}
