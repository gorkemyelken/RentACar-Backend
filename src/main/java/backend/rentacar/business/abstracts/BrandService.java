package backend.rentacar.business.abstracts;

import backend.rentacar.entities.concretes.Brand;

import java.util.List;

public interface BrandService {
    List<Brand> getAll();
}
