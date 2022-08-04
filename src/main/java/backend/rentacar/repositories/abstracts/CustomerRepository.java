package backend.rentacar.repositories.abstracts;

import backend.rentacar.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerId(int customerId);
    boolean existsByCustomerId(int customerId);
    boolean existsByEmail(String email);
    boolean existsByNationalityNumber(String nationalityNumber);
}
