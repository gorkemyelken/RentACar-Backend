package backend.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","rentals"})
public class Customer{
    public Customer(String firstName, String lastName, String nationalityNumber, int birthYear, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nationalityNumber = nationalityNumber;
        this.birthYear = birthYear;
        this.email = email;
        this.password = password;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="nationality_number")
    private String nationalityNumber;

    @Column(name="birth_year")
    private int birthYear;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Rental> rentals;
}
