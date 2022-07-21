package backend.rentacar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    @JoinColumn(name="customer_id")
    private Customer customer;

    @Column(name = "rent_date")
    private LocalDateTime rentDate;

    @Column(name="return_date")
    private LocalDateTime returnDate;
}
