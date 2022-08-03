package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.BrandService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.repositories.abstracts.BrandRepository;
import backend.rentacar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandManager(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public DataResult<List<Brand>> getAll() {
        return new SuccessDataResult<List<Brand>>(this.brandRepository.findAll(),"Brands listed.");
    }

    @Override
    public DataResult<List<Brand>> getAllByBrandNameAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"brandName");
        return new SuccessDataResult<List<Brand>>(this.brandRepository.findAll(sort),"The brands were sorted in ascending alphabet of the brand name.");
    }

    @Override
    public DataResult<List<Brand>> getAllByBrandNameDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"brandName");
        return new SuccessDataResult<List<Brand>>(this.brandRepository.findAll(sort),"The brands were sorted in descending alphabet of the brand name.");
    }

    @Override
    public Result add(Brand brand) {
        this.brandRepository.save(brand);
        return new SuccessResult("Brand added.");
    }

    @Override
    public DataResult<Brand> findByBrandId(int brandId) {
        return new SuccessDataResult<Brand>(this.brandRepository.findByBrandId(brandId),"Brand listed by id.");
    }

    @Override
    public DataResult<Brand> findByBrandName(String brandName) {
        return new SuccessDataResult<Brand>(this.brandRepository.findByBrandName(brandName),"Brand listed by name.");
    }
}
