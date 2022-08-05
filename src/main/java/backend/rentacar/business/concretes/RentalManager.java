package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.RentalService;
import backend.rentacar.business.constants.Messages;
import backend.rentacar.core.utilities.mapping.ModelMapperService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.ErrorDataResult;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.entities.dtos.rentaldto.RentalCreateDto;
import backend.rentacar.entities.dtos.rentaldto.RentalUpdateDto;
import backend.rentacar.entities.dtos.rentaldto.RentalViewDto;
import backend.rentacar.repositories.abstracts.RentalRepository;
import backend.rentacar.entities.concretes.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalManager implements RentalService {

    private final RentalRepository rentalRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public RentalManager(RentalRepository rentalRepository, ModelMapperService modelMapperService) {
        this.rentalRepository = rentalRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<RentalViewDto>> getAll() {
        List<Rental> rentals = this.rentalRepository.findAll();
        List<RentalViewDto> result = rentals.stream().map(rental -> this.modelMapperService.forDto().map(rental, RentalViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.GlobalMessages.DATA_LISTED);   }

    @Override
    public DataResult<RentalViewDto> findByRentalId(int rentalId) {
        if(!checkIfRentalIdExists(rentalId)){
            return new ErrorDataResult<>(Messages.RentalMessages.RENTAL_ID_NOT_FOUND);
        }
        else{
        Rental rental = this.rentalRepository.findByRentalId(rentalId);
        RentalViewDto result = this.modelMapperService.forDto().map(rental, RentalViewDto.class);
        return new SuccessDataResult<>(result, Messages.RentalMessages.RENTAL_LISTED_BY_RENTAL_ID);  }   }

    @Override
    public DataResult<RentalViewDto> add(RentalCreateDto rentalCreateDto) {
        Rental rental = this.rentalRepository.save(new Rental(rentalCreateDto.getCar(),rentalCreateDto.getCustomer(),rentalCreateDto.getRentDate(),rentalCreateDto.getReturnDate()));
        return new SuccessDataResult<>(RentalViewDto.of(rental), Messages.GlobalMessages.DATA_ADDED);
    }

    @Override
    public DataResult<RentalViewDto> update(int rentalId, RentalUpdateDto rentalUpdateDto) {
        if(!checkIfRentalIdExists(rentalId)){
            return new ErrorDataResult<>(Messages.RentalMessages.RENTAL_ID_NOT_FOUND);
        }
        else{
            Rental rental = this.rentalRepository.findByRentalId(rentalId);
            rental.setCar(rentalUpdateDto.getCar());
            rental.setCustomer(rentalUpdateDto.getCustomer());
            rental.setRentDate(rentalUpdateDto.getRentDate());
            rental.setReturnDate(rentalUpdateDto.getReturnDate());
            this.rentalRepository.save(rental);
            return new SuccessDataResult<>(RentalViewDto.of(rental), Messages.GlobalMessages.DATA_UPDATED);
        }
    }

    @Override
    public DataResult<RentalViewDto> delete(int rentalId) {
        if(!checkIfRentalIdExists(rentalId)){
            return new ErrorDataResult<>(Messages.RentalMessages.RENTAL_ID_NOT_FOUND);
        }
        else{
            Rental rental = this.rentalRepository.findByRentalId(rentalId);
            this.rentalRepository.deleteById(rentalId);
            return new SuccessDataResult<>(RentalViewDto.of(rental), Messages.GlobalMessages.DATA_DELETED);
        }
    }

    @Override
    public DataResult<List<RentalViewDto>> getAllByRentDateAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"rentDate");
        List<Rental> rentals = this.rentalRepository.findAll(sort);
        List<RentalViewDto> result = rentals.stream().map(rental -> this.modelMapperService.forDto().map(rental, RentalViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.RentalMessages.RENTAL_LISTED_BY_RENT_DATE_ASC);  }

    @Override
    public DataResult<List<RentalViewDto>> getAllByRentDateDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"rentDate");
        List<Rental> rentals = this.rentalRepository.findAll(sort);
        List<RentalViewDto> result = rentals.stream().map(rental -> this.modelMapperService.forDto().map(rental, RentalViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.RentalMessages.RENTAL_LISTED_BY_RENT_DATE_DESC);    }

    @Override
    public DataResult<List<RentalViewDto>> getAllByReturnDateAsc() {
        Sort sort = Sort.by(Sort.Direction.ASC,"returnDate");
        List<Rental> rentals = this.rentalRepository.findAll(sort);
        List<RentalViewDto> result = rentals.stream().map(rental -> this.modelMapperService.forDto().map(rental, RentalViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.RentalMessages.RENTAL_LISTED_BY_RETURN_DATE_ASC);    }

    @Override
    public DataResult<List<RentalViewDto>> getAllByReturnDateDesc() {
        Sort sort = Sort.by(Sort.Direction.DESC,"returnDate");
        List<Rental> rentals = this.rentalRepository.findAll(sort);
        List<RentalViewDto> result = rentals.stream().map(rental -> this.modelMapperService.forDto().map(rental, RentalViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.RentalMessages.RENTAL_LISTED_BY_RETURN_DATE_DESC);    }

    private boolean checkIfRentalIdExists(int rentalId) {
        return this.rentalRepository.existsByRentalId(rentalId);
    }
}
