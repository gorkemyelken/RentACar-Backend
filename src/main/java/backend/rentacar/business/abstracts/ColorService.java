package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Color;

import java.util.List;

public interface ColorService {
    DataResult<List<Color>> getAll();

    Result add(Color color);
}
