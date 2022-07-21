package backend.rentacar.dataAccess.abstracts;

import backend.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandDao extends JpaRepository<Brand,Integer> {
    Brand findByBrandId(int brandId);
    Brand findByBrandName(String brandName);
}
