package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.BrandService;
import backend.rentacar.business.constants.Messages;
import backend.rentacar.core.utilities.mapping.ModelMapperService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.ErrorDataResult;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.entities.concretes.User;
import backend.rentacar.entities.dtos.branddto.BrandCreateDto;
import backend.rentacar.entities.dtos.branddto.BrandUpdateDto;
import backend.rentacar.entities.dtos.branddto.BrandViewDto;
import backend.rentacar.entities.dtos.userdto.UserViewDto;
import backend.rentacar.repositories.abstracts.BrandRepository;
import backend.rentacar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public BrandManager(BrandRepository brandRepository, ModelMapperService modelMapperService) {
        this.brandRepository = brandRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<BrandViewDto>> getAll() {
        List<Brand> brands = this.brandRepository.findAll();
        List<BrandViewDto> result = brands.stream().map(brand -> this.modelMapperService.forDto().map(brand, BrandViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.GlobalMessages.DATA_LISTED);
    }

    @Override
    public DataResult<List<BrandViewDto>> getAllByBrandNameAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"brandName");
        List<Brand> brands = this.brandRepository.findAll(sort);
        List<BrandViewDto> result = brands.stream().map(brand -> this.modelMapperService.forDto().map(brand, BrandViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.BrandMessages.BRAND_LISTED_BY_BRAND_NAME_ASC);   }

    @Override
    public DataResult<List<BrandViewDto>> getAllByBrandNameDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"brandName");
        List<Brand> brands = this.brandRepository.findAll(sort);
        List<BrandViewDto> result = brands.stream().map(brand -> this.modelMapperService.forDto().map(brand, BrandViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.BrandMessages.BRAND_LISTED_BY_BRAND_NAME_DESC);    }

    @Override
    public DataResult<BrandViewDto> add(BrandCreateDto brandCreateDto) {
        Brand brand = this.brandRepository.save(new Brand(brandCreateDto.getBrandName()));
        return new SuccessDataResult<>(BrandViewDto.of(brand), Messages.GlobalMessages.DATA_ADDED);
    }

    @Override
    public DataResult<BrandViewDto> update(int brandId, BrandUpdateDto brandUpdateDto) {
        if(!checkIfBrandIdExists(brandId)){
            return new ErrorDataResult<>(Messages.BrandMessages.BRAND_ID_NOT_FOUND);
        }
        else{
            Brand brand = this.brandRepository.findByBrandId(brandId);
            brand.setBrandName(brandUpdateDto.getBrandName());
            this.brandRepository.save(brand);
            return new SuccessDataResult<>(BrandViewDto.of(brand), Messages.GlobalMessages.DATA_UPDATED);
        }
    }

    @Override
    public DataResult<BrandViewDto> delete(int brandId) {
        if(!checkIfBrandIdExists(brandId)){
            return new ErrorDataResult<>(Messages.BrandMessages.BRAND_ID_NOT_FOUND);
        }
        else{
            Brand brand = this.brandRepository.findByBrandId(brandId);
            this.brandRepository.deleteById(brandId);
            return new SuccessDataResult<>(BrandViewDto.of(brand), Messages.GlobalMessages.DATA_DELETED);
        }
    }

    @Override
    public DataResult<BrandViewDto> findByBrandId(int brandId) {
        Brand brand = this.brandRepository.findByBrandId(brandId);
        BrandViewDto result = this.modelMapperService.forDto().map(brand, BrandViewDto.class);
        return new SuccessDataResult<>(result, Messages.BrandMessages.BRAND_LISTED_BY_BRAND_ID);     }

    @Override
    public DataResult<BrandViewDto> findByBrandName(String brandName) {
        Brand brand = this.brandRepository.findByBrandName(brandName);
        BrandViewDto result = this.modelMapperService.forDto().map(brand, BrandViewDto.class);
        return new SuccessDataResult<>(result, Messages.BrandMessages.BRAND_LISTED_BY_BRAND_NAME);
    }

    private boolean checkIfBrandIdExists(int brandId) {
        if(this.brandRepository.existsByBrandId(brandId)){
            return true;
        }
        return false;
    }
}
