package physiodesk.physiodesk_backend.Users.interfaces.rest.resources.physio;

import java.time.LocalTime;
import java.util.List;

public record CreatePhysioResource(long id, String nombre, String imagen, String biografia, Short edad, List<LocalTime> horarios) {
    public CreatePhysioResource{
        if (id < 0){
            throw new IllegalArgumentException("Id must be greater than or equal to 0");
        }
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre cannot be null or empty");
        }
        if (imagen == null || imagen.isBlank()) {
            throw new IllegalArgumentException("Imagen cannot be null or empty");
        }
        if (biografia == null || biografia.isBlank()) {
            throw new IllegalArgumentException("Biografia cannot be null or empty");
        }
        if (edad < 0) {
            throw new IllegalArgumentException("Edad must be greater than 0");
        }
        if (horarios == null || horarios.isEmpty()) {
            throw new IllegalArgumentException("Horarios cannot be null");
        }
        for (LocalTime horario : horarios) {
            if (horario == null) {
                throw new IllegalArgumentException("Horario times cannot be null");
            }
        }
    }
}
