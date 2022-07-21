package backend.rentacar.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name="colors")
@AllArgsConstructor
@NoArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="color_id")
    private int colorId;

    @Column(name="color_name")
    private String colorName;

    @OneToMany(mappedBy = "colors")
    private List<Car> Cars;
}
