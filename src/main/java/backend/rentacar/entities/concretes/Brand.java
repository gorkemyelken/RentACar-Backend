package backend.rentacar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="brands")
@AllArgsConstructor
@NoArgsConstructor
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="brand_id")
    private int brandId;

    @Column(name="brand_name")
    private String brandName;

    @OneToMany(mappedBy = "brands")
    private List<Car> Cars;
}
