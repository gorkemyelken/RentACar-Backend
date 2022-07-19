package backend.rentacar.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="brands")
public class Brand {
    @Id
    @GeneratedValue
    @Column(name="brand_id")
    private int brandId;

    @Column(name="brand_name")
    private String brandName;
}
