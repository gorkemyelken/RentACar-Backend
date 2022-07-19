package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.BrandService;
import backend.rentacar.dataAccess.abstracts.BrandDao;
import backend.rentacar.entities.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Brand> getAll() {
        return null;
    }
}
