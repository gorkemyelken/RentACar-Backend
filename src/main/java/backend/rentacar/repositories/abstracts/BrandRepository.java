package backend.rentacar.repositories.abstracts;

import backend.rentacar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandRepository extends JpaRepository<Brand,Integer> {
    Brand findByBrandId(int brandId);
    Brand findByBrandName(String brandName);
    boolean existsByBrandId(int brandId);
    boolean existsByBrandName(String brandName);
}
