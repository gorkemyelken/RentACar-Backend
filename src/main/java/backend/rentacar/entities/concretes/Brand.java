package backend.rentacar.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="brands")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","cars"})
public class Brand {
    public Brand(String brandName, String brandImagePath){
        this.brandName = brandName;
        this.brandImagePath = brandImagePath;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="brand_id")
    private int brandId;

    @Column(name="brand_name")
    private String brandName;

    @Column(name="brand_image_path")
    private String brandImagePath;

    @OneToMany(mappedBy = "brand")
    private List<Car> cars;
}
