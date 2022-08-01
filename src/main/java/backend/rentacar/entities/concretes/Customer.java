package backend.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private int customerId;

    @Column(name="first_name")
    @NotNull
    @NotBlank
    private String firstName;

    @Column(name="last_name")
    @NotNull
    @NotBlank
    private String lastName;

    @Column(name="nationality_number")
    @NotNull
    @NotBlank
    private String nationalityNumber;

    @Column(name="birth_year")
    @NotNull
    @NotBlank
    private int birthYear;

    @Column(name="email")
    @Email
    @NotNull
    @NotBlank
    private String email;

    @Column(name="password")
    @NotNull
    @NotBlank
    private String password;
}
