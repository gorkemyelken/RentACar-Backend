package backend.rentacar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
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
}
