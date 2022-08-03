package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Color;

import java.util.List;

public interface ColorService {
    DataResult<List<Color>> getAll();
    DataResult<List<Color>> getAllByColorNameAsc();
    DataResult<List<Color>> getAllByColorNameDesc();
    Result add(Color color);
    DataResult<Color> findByColorId(int colorId);
    DataResult<Color> findByColorName(String colorName);
}
