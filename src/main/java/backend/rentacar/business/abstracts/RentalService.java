package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Rental;

public interface RentalService {
    DataResult<Rental> findByRentalId(int rental_id);
    Result add(Rental rental);
}
