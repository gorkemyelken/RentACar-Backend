package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.ColorService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.dataAccess.abstracts.ColorDao;
import backend.rentacar.entities.concretes.Color;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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

        return new SuccessDataResult<List<Color>>(this.colorDao.findAll(),"Colors listed.");
    }

    @Override
    public DataResult<List<Color>> getAllByColorNameAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"colorName");
        return new SuccessDataResult<List<Color>>(this.colorDao.findAll(sort),"The colors were sorted in ascending alphabet of the color name.");
    }

    @Override
    public DataResult<List<Color>> getAllByColorNameDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"colorName");
        return new SuccessDataResult<List<Color>>(this.colorDao.findAll(sort),"The colors were sorted in descending alphabet of the color name.");
    }

    @Override
    public Result add(Color color) {
        this.colorDao.save(color);
        return new SuccessResult("Color added.");
    }

    @Override
    public DataResult<Color> findByColorId(int colorId) {
        return new SuccessDataResult<Color>(this.colorDao.findByColorId(colorId),"Color listed by id.");
    }

    @Override
    public DataResult<Color> findByColorName(String colorName) {
        return new SuccessDataResult<Color>(this.colorDao.findByColorName(colorName),"Color listed by name.");
    }
}
