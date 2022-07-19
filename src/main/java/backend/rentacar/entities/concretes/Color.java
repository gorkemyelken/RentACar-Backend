package backend.rentacar.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="colors")
public class Color {
    @Id
    @GeneratedValue
    @Column(name="color_id")
    private int colorId;

    @Column(name="color_name")
    private String colorName;
}
