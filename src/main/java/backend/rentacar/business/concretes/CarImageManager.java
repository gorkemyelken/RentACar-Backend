package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CarImageService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.entities.concretes.Brand;
import backend.rentacar.entities.concretes.CarImage;
import backend.rentacar.repositories.abstracts.CarImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImageManager implements CarImageService {
    private CarImageRepository carImageRepository;

    @Autowired
    public CarImageManager(CarImageRepository carImageRepository) {
        this.carImageRepository = carImageRepository;
    }

    @Override
    public DataResult<List<CarImage>> getAll() {
        return new SuccessDataResult<List<CarImage>>(this.carImageRepository.findAll(),"Car images listed.");
    }
}
