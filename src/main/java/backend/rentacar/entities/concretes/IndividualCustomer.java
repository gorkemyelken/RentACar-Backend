package backend.rentacar.entities.concretes;

import backend.rentacar.entities.abstracts.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="individual_customers")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "individual_customer_id", referencedColumnName = "user_id")
public class IndividualCustomer extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="individual_customer_id")
    private int individualCustomerId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="nationality_number")
    private String nationalityNumber;

    @Column(name="birth_date")
    private Date birthDate;
}
