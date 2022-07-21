package backend.rentacar.dataAccess.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalDao extends JpaRepository<Rental, Integer> {
    Rental findByRentalId(int rental_id);
}
