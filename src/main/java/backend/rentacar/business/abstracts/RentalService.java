package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Color;
import backend.rentacar.entities.concretes.Rental;

import java.util.List;

public interface RentalService {
    DataResult<List<Rental>> getAll();
    DataResult<Rental> findByRentalId(int rental_id);
    Result add(Rental rental);
    DataResult<List<Rental>> getAllByRentDateAsc();
    DataResult<List<Rental>> getAllByRentDateDesc();
    DataResult<List<Rental>> getAllByReturnDateAsc();
    DataResult<List<Rental>> getAllByReturnDateDesc();
}
