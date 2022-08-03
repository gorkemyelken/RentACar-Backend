package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.colordto.ColorCreateDto;
import backend.rentacar.entities.dtos.colordto.ColorViewDto;

import java.util.List;

public interface ColorService {
    DataResult<List<ColorViewDto>> getAll();
    DataResult<List<ColorViewDto>> getAllByColorNameAsc();
    DataResult<List<ColorViewDto>> getAllByColorNameDesc();
    DataResult<ColorViewDto> add(ColorCreateDto colorCreateDto);
    DataResult<ColorViewDto> findByColorId(int colorId);
    DataResult<ColorViewDto> findByColorName(String colorName);
}
