package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Customer;
import backend.rentacar.entities.dtos.customerdto.CustomerCreateDto;
import backend.rentacar.entities.dtos.customerdto.CustomerViewDto;

import java.util.List;

public interface CustomerService {
    DataResult<List<CustomerViewDto>> getall();
    DataResult<CustomerViewDto> add(CustomerCreateDto customerCreateDto);
}
