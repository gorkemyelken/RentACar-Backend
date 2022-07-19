package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CarService;
import backend.rentacar.dataAccess.abstracts.CarDao;
import backend.rentacar.entities.concretes.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarManager implements CarService {

    private CarDao carDao;

    @Autowired
    public CarManager(CarDao carDao) {
        this.carDao = carDao;
    }

    @Override
    public List<Car> getAll() {
        return this.carDao.findAll();
    }
}
