package physiodesk.physiodesk_backend.Users.interfaces.rest.resources.physio;

import java.time.LocalTime;
import java.util.List;

public record physioResource(Long id, String nombre, String imagen, String biografia, Short edad, List<LocalTime> horarios) {
}
