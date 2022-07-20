package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.ColorService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.dataAccess.abstracts.ColorDao;
import backend.rentacar.entities.concretes.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorManager implements ColorService {
    private ColorDao colorDao;

    @Autowired
    public ColorManager(ColorDao colorDao) {
        this.colorDao = colorDao;
    }

    @Override
    public DataResult<List<Color>> getAll() {

        return new SuccessDataResult<>(this.colorDao.findAll(),"Colors listed.");
    }

    @Override
    public Result add(Color color) {
        this.colorDao.save(color);
        return new SuccessResult("Color added.");
    }
}
