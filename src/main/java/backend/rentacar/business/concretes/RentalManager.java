package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.RentalService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.dataAccess.abstracts.RentalDao;
import backend.rentacar.entities.concretes.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalManager implements RentalService {

    private RentalDao rentalDao;

    @Autowired
    public RentalManager(RentalDao rentalDao) {
        this.rentalDao = rentalDao;
    }

    @Override
    public DataResult<Rental> findByRentalId(int rental_id) {
        return new SuccessDataResult<>(this.rentalDao.findByRentalId(rental_id),"Rental listed by id.");
    }

    @Override
    public Result add(Rental rental) {
        this.rentalDao.save(rental);
        return new SuccessResult("Rental added.");
    }
}
