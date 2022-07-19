package backend.rentacar.business.abstracts;

import backend.rentacar.entities.concretes.Color;

import java.util.List;

public interface ColorService {
    List<Color> getAll();
}
