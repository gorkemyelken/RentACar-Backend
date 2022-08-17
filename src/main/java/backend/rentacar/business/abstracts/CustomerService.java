package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.customerdto.CustomerCreateDto;
import backend.rentacar.entities.dtos.customerdto.CustomerUpdateDto;
import backend.rentacar.entities.dtos.customerdto.CustomerViewDto;

import java.util.List;

public interface CustomerService {
    DataResult<List<CustomerViewDto>> getAll();
    DataResult<CustomerViewDto> add(CustomerCreateDto customerCreateDto);
    DataResult<CustomerViewDto> update(int customerId, CustomerUpdateDto customerUpdateDto);
    DataResult<CustomerViewDto> delete(int customerId);
    DataResult<CustomerViewDto> findByCustomerId(int customerId);
}
