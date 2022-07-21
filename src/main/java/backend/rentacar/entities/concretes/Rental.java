package backend.rentacar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="rentals")
@AllArgsConstructor
@NoArgsConstructor
public class Rental {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rental_id")
    private int rentalId;

    @OneToOne()
    @JoinColumn(name="car_id")
    private Car car;

    @OneToOne()
    @JoinColumn(name="individual_customer_id")
    private IndividualCustomer individualCustomer;

    @Column(name = "rent_date")
    private Date rentDate;

    @Column(name="return_date")
    private Date returnDate;
}
