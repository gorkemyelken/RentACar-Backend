package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.DataResult;
import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Customer;

import java.util.List;

public interface CustomerService {
    DataResult<List<Customer>> getall();
    Result add(Customer customer);
}
