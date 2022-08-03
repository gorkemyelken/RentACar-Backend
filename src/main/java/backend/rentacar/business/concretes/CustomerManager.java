package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CustomerService;
import backend.rentacar.core.utilities.mapping.ModelMapperService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.entities.dtos.customerdto.CustomerCreateDto;
import backend.rentacar.entities.dtos.customerdto.CustomerViewDto;
import backend.rentacar.repositories.abstracts.CustomerRepository;
import backend.rentacar.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository, ModelMapperService modelMapperService) {
        this.customerRepository = customerRepository;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public DataResult<List<CustomerViewDto>> getall() {
        List<Customer> customers = this.customerRepository.findAll();
        List<CustomerViewDto> result = customers.stream().map(customer -> this.modelMapperService.forDto().map(customer, CustomerViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result);
            }

    @Override
    public DataResult<CustomerViewDto> add(CustomerCreateDto customerCreateDto) {
        Customer customer = this.customerRepository.save(new Customer(customerCreateDto.getFirstName(), customerCreateDto.getLastName(), customerCreateDto.getNationalityNumber(), customerCreateDto.getBirthYear(), customerCreateDto.getEmail(), customerCreateDto.getPassword()));
        return new SuccessDataResult<>(CustomerViewDto.of(customer));
    }
}
