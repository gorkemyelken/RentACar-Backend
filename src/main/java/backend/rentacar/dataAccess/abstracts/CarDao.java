package backend.rentacar.dataAccess.abstracts;

import backend.rentacar.entities.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarDao extends JpaRepository<Car,Integer> {
}
