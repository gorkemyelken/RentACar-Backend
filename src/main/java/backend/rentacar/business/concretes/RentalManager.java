package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.RentalService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.dataAccess.abstracts.RentalDao;
import backend.rentacar.entities.concretes.Color;
import backend.rentacar.entities.concretes.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalManager implements RentalService {

    private RentalDao rentalDao;

    @Autowired
    public RentalManager(RentalDao rentalDao) {
        this.rentalDao = rentalDao;
    }

    @Override
    public DataResult<List<Rental>> getAll() {
        return new SuccessDataResult<>(this.rentalDao.findAll(),"Rentals listed.");
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

    @Override
    public DataResult<List<Rental>> getAllByRentDateAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"rentDate");
        return new SuccessDataResult<>(this.rentalDao.findAll(sort),"The rentals were sorted in ascending of the rent date.");
    }

    @Override
    public DataResult<List<Rental>> getAllByRentDateDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"rentDate");
        return new SuccessDataResult<>(this.rentalDao.findAll(sort),"The rentals were sorted in descending of the rent date.");
    }

    @Override
    public DataResult<List<Rental>> getAllByReturnDateAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"returnDate");
        return new SuccessDataResult<>(this.rentalDao.findAll(sort),"The rentals were sorted in ascending of the return date.");
    }

    @Override
    public DataResult<List<Rental>> getAllByReturnDateDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"returnDate");
        return new SuccessDataResult<>(this.rentalDao.findAll(sort),"The rentals were sorted in descending of the return date.");
    }
}
