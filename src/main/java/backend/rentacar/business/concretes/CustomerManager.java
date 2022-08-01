package backend.rentacar.business.concretes;

import backend.rentacar.business.abstracts.CustomerService;
import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.core.utilities.results.SuccessDataResult;
import backend.rentacar.core.utilities.results.SuccessResult;
import backend.rentacar.repositories.abstracts.CustomerRepository;
import backend.rentacar.entities.concretes.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerManager implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerManager(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public DataResult<List<Customer>> getall() {
        return new SuccessDataResult<List<Customer>>(this.customerRepository.findAll(),"Customers listed.");
    }

    @Override
    public Result add(Customer customer) {
        this.customerRepository.save(customer);
        return new SuccessResult("Customer added.");
    }
}
