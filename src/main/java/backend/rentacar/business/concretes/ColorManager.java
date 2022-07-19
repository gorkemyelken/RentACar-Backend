package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.ColorService;
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
    public List<Color> getAll() {
        return this.colorDao.findAll();
    }
}
