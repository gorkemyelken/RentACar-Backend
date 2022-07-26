package backend.rentacar.dataAccess.abstracts;

import backend.rentacar.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}
