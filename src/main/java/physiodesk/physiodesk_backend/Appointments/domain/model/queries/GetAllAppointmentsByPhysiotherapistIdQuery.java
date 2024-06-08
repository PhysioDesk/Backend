package physiodesk.physiodesk_backend.Appointments.domain.model.queries;

public record GetAllAppointmentsByPhysiotherapistIdQuery(Long physiotherapistId) {

    public GetAllAppointmentsByPhysiotherapistIdQuery {
        if (physiotherapistId == null) {
            throw new IllegalArgumentException("Physiotherapist id must be greater than 0");
        }
    }
}
