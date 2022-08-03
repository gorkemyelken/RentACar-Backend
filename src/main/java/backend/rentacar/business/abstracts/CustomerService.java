package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.entities.dtos.customerdto.CustomerCreateDto;
import backend.rentacar.entities.dtos.customerdto.CustomerViewDto;

import java.util.List;

public interface CustomerService {
    DataResult<List<CustomerViewDto>> getall();
    DataResult<CustomerViewDto> add(CustomerCreateDto customerCreateDto);
}
