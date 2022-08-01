package backend.rentacar.repositories.abstracts;

import backend.rentacar.entities.concretes.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Integer> {
    Rental findByRentalId(int rental_id);
}
