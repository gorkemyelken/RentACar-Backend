package backend.rentacar.business.abstracts;

import backend.rentacar.core.utilities.results.Result;
import backend.rentacar.entities.concretes.Customer;

public interface CustomerService {
    Result add(Customer customer);
}
