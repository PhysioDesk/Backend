package physiodesk.physiodesk_backend.Users.domain.model.commands.physio;

import java.time.LocalTime;
import java.util.List;

public record CreatePhysioCommand(long id, String nombre, String imagen, String biografia, Short edad, List<LocalTime> horarios) {

    public CreatePhysioCommand{
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Nombre cannot be null");
        }
        if (imagen == null || imagen.isBlank()) {
            throw new IllegalArgumentException("Imagen cannot be null");
        }
        if (biografia == null || biografia.isBlank()) {
            throw new IllegalArgumentException("Biografia cannot be null");
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
