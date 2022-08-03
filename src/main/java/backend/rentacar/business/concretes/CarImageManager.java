package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CarImageService;
import backend.rentacar.core.utilities.mapping.ModelMapperService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.entities.concretes.CarImage;
import backend.rentacar.entities.dtos.carimagedto.CarImageCreateDto;
import backend.rentacar.entities.dtos.carimagedto.CarImageViewDto;
import backend.rentacar.repositories.abstracts.CarImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarImageManager implements CarImageService {
    private final CarImageRepository carImageRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public CarImageManager(CarImageRepository carImageRepository, ModelMapperService modelMapperService) {
        this.carImageRepository = carImageRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<CarImageViewDto>> getAll() {
        List<CarImage> carImages = this.carImageRepository.findAll();
        List<CarImageViewDto> result = carImages.stream().map(carImage -> this.modelMapperService.forDto().map(carImage,CarImageViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);  }

    @Override
    public DataResult<CarImageViewDto> add(CarImageCreateDto carImageCreateDto) {
        CarImage carImage = this.carImageRepository.save(new CarImage(carImageCreateDto.getImagePath()));
        return new SuccessDataResult<>(CarImageViewDto.of(carImage));
    }

}
