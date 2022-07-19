package backend.rentacar.business.abstracts;

import backend.rentacar.entities.concretes.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();
}
