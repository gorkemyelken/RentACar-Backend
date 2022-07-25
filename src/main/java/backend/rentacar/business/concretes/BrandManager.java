package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.BrandService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.dataAccess.abstracts.BrandDao;
import backend.rentacar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandManager implements BrandService {

    private BrandDao brandDao;

    @Autowired
    public BrandManager(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    @Override
    public DataResult<List<Brand>> getAll() {
        return new SuccessDataResult<>(this.brandDao.findAll(),"Brands listed.");
    }

    @Override
    public DataResult<List<Brand>> getAllByBrandNameAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"brandName");
        return new SuccessDataResult<>(this.brandDao.findAll(sort),"The brands were sorted in ascending alphabet of the brand name.");
    }

    @Override
    public DataResult<List<Brand>> getAllByBrandNameDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"brandName");
        return new SuccessDataResult<>(this.brandDao.findAll(sort),"The brands were sorted in descending alphabet of the brand name.");
    }

    @Override
    public Result add(Brand brand) {
        this.brandDao.save(brand);
        return new SuccessResult("Brand added.");
    }

    @Override
    public DataResult<Brand> findByBrandId(int brandId) {
        return new SuccessDataResult<>(this.brandDao.findByBrandId(brandId),"Brand listed by id.");
    }

    @Override
    public DataResult<Brand> findByBrandName(String brandName) {
        return new SuccessDataResult<>(this.brandDao.findByBrandName(brandName),"Brand listed by name.");
    }
}
