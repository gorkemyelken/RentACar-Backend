package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.carimagedto.CarImageCreateDto;
import backend.rentacar.entities.dtos.carimagedto.CarImageViewDto;

import java.util.List;

public interface CarImageService {
    DataResult<List<CarImageViewDto>> getAll();

    DataResult<CarImageViewDto> add(CarImageCreateDto carImageCreateDto);
}
