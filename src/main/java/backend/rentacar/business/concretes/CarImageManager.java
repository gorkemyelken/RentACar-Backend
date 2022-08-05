package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CarImageService;
import backend.rentacar.business.constants.Messages;
import backend.rentacar.core.utilities.mapping.ModelMapperService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.ErrorDataResult;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.entities.concretes.CarImage;
import backend.rentacar.entities.dtos.carimagedto.CarImageCreateDto;
import backend.rentacar.entities.dtos.carimagedto.CarImageUpdateDto;
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
        return new SuccessDataResult<>(result, Messages.GlobalMessages.DATA_LISTED);  }

    @Override
    public DataResult<CarImageViewDto> add(CarImageCreateDto carImageCreateDto) {
        if(checkIfImagePathExists(carImageCreateDto.getImagePath())){
            return new ErrorDataResult<>(Messages.CarImageMessages.IMAGE_PATH_ALREADY_EXIST);
        }
        else{
            CarImage carImage = this.carImageRepository.save(new CarImage(carImageCreateDto.getImagePath(), carImageCreateDto.getCar()));
            return new SuccessDataResult<>(CarImageViewDto.of(carImage), Messages.GlobalMessages.DATA_ADDED);
        }

    }

    @Override
    public DataResult<CarImageViewDto> update(int carImageId, CarImageUpdateDto carImageUpdateDto) {
        if(!checkIfCarImageIdExists(carImageId)){
            return new ErrorDataResult<>(Messages.CarImageMessages.CAR_IMAGE_ID_NOT_FOUND);
        }
        else{
            CarImage carImage = this.carImageRepository.findByCarImageId(carImageId);
            carImage.setImagePath(carImageUpdateDto.getImagePath());
            carImage.setCar(carImageUpdateDto.getCar());
            this.carImageRepository.save(carImage);
            return new SuccessDataResult<>(CarImageViewDto.of(carImage), Messages.GlobalMessages.DATA_UPDATED);
        }
    }



    @Override
    public DataResult<CarImageViewDto> delete(int carImageId) {
        if(!checkIfCarImageIdExists(carImageId)){
            return new ErrorDataResult<>(Messages.CarImageMessages.CAR_IMAGE_ID_NOT_FOUND);
        }
        else{
            CarImage carImage = this.carImageRepository.findByCarImageId(carImageId);
            this.carImageRepository.deleteById(carImageId);
            return new SuccessDataResult<>(CarImageViewDto.of(carImage), Messages.GlobalMessages.DATA_DELETED);
        }
    }

    private boolean checkIfImagePathExists(String imagePath) {
        return this.carImageRepository.existsByImagePath(imagePath);
    }
    private boolean checkIfCarImageIdExists(int carImageId) {
        return this.carImageRepository.existsByCarImageId(carImageId);
    }

}
