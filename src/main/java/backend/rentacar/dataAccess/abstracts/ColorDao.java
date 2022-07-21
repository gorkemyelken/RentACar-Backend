package backend.rentacar.dataAccess.abstracts;

import backend.rentacar.entities.concretes.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorDao extends JpaRepository<Color,Integer> {
    Color findByColorId(int colorId);
    Color findByColorName(String colorName);
}
