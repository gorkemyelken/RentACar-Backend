package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CustomerService;
import backend.rentacar.business.constants.Messages;
import backend.rentacar.core.utilities.mapping.ModelMapperService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.ErrorDataResult;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.entities.dtos.customerdto.CustomerCreateDto;
import backend.rentacar.entities.dtos.customerdto.CustomerUpdateDto;
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
    public DataResult<List<CustomerViewDto>> getAll() {
        List<Customer> customers = this.customerRepository.findAll();
        List<CustomerViewDto> result = customers.stream().map(customer -> this.modelMapperService.forDto().map(customer, CustomerViewDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<>(result, Messages.GlobalMessages.DATA_LISTED);
            }

    @Override
    public DataResult<CustomerViewDto> add(CustomerCreateDto customerCreateDto) {
        if(checkIfCustomerEmailExists(customerCreateDto.getEmail())){
            return new ErrorDataResult<>(Messages.CustomerMessages.CUSTOMER_EMAIL_ALREADY_EXIST);
        }
        else if(checkIfCustomerNationalityNumberExists(customerCreateDto.getNationalityNumber())){
            return new ErrorDataResult<>(Messages.CustomerMessages.CUSTOMER_NATIONALITY_NUMBER_ALREADY_EXIST);
        }
        else{
            Customer customer = this.customerRepository.save(new Customer(customerCreateDto.getFirstName(), customerCreateDto.getLastName(), customerCreateDto.getNationalityNumber(), customerCreateDto.getBirthYear(), customerCreateDto.getEmail(), customerCreateDto.getPassword()));
            return new SuccessDataResult<>(CustomerViewDto.of(customer), Messages.GlobalMessages.DATA_ADDED);
        }
    }

    @Override
    public DataResult<CustomerViewDto> update(int customerId, CustomerUpdateDto customerUpdateDto) {
        if(!checkIfCustomerIdExists(customerId)){
            return new ErrorDataResult<>(Messages.CustomerMessages.CUSTOMER_ID_NOT_FOUND);
        }
        else{
            Customer customer = this.customerRepository.findByCustomerId(customerId);
            customer.setEmail(customerUpdateDto.getEmail());
            customer.setBirthYear(customerUpdateDto.getBirthYear());
            customer.setFirstName(customerUpdateDto.getFirstName());
            customer.setLastName(customerUpdateDto.getLastName());
            customer.setNationalityNumber(customerUpdateDto.getNationalityNumber());
            customer.setPassword(customerUpdateDto.getPassword());
            this.customerRepository.save(customer);
            return new SuccessDataResult<>(CustomerViewDto.of(customer), Messages.GlobalMessages.DATA_UPDATED);
        }
    }

    @Override
    public DataResult<CustomerViewDto> delete(int customerId) {
        if(!checkIfCustomerIdExists(customerId)){
            return new ErrorDataResult<>(Messages.CustomerMessages.CUSTOMER_ID_NOT_FOUND);
        }
        else{
            Customer customer = this.customerRepository.findByCustomerId(customerId);
            this.customerRepository.deleteById(customerId);
            return new SuccessDataResult<>(CustomerViewDto.of(customer), Messages.GlobalMessages.DATA_DELETED);
        }
    }

    @Override
    public DataResult<CustomerViewDto> findByCustomerId(int customerId) {
        if(!checkIfCustomerIdExists(customerId)){
            return new ErrorDataResult<>(Messages.CustomerMessages.CUSTOMER_ID_NOT_FOUND);
        }
        else{
            Customer customer = this.customerRepository.findByCustomerId(customerId);
            CustomerViewDto result = this.modelMapperService.forDto().map(customer, CustomerViewDto.class);
            return new SuccessDataResult<>(result, Messages.CustomerMessages.CUSTOMER_LISTED_BY_CUSTOMER_ID);
        }
    }

    private boolean checkIfCustomerIdExists(int customerId) {
        if(this.customerRepository.existsByCustomerId(customerId)){
            return true;
        }
        return false;
    }

    private boolean checkIfCustomerNationalityNumberExists(String nationalityNumber) {
        if(this.customerRepository.existsByNationalityNumber(nationalityNumber)){
            return true;
        }
        return false;
    }

    private boolean checkIfCustomerEmailExists(String email) {
        if(this.customerRepository.existsByEmail(email)){
            return true;
        }
        return false;
    }
}
