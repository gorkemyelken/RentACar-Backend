package backend.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Table(name="rentals")
@AllArgsConstructor
@NoArgsConstructor
public class Rental {
    public Rental(Car car, Customer customer, Date rentDate, Date returnDate) {
        this.car = car;
        this.customer = customer;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rental_id")
    private int rentalId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="car_id")
    @JsonIgnore
    private Car car;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="customer_id")
    @JsonIgnore
    private Customer customer;

    @Column(name = "rent_date")
    private java.sql.Date rentDate;

    @Column(name="return_date")
    private java.sql.Date returnDate;
}
