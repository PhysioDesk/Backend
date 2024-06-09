package physiodesk.physiodesk_backend.Appointments.domain.model.queries;

public record GetAppointmentByIdQuery(Long id) {
    public GetAppointmentByIdQuery {
        if (id == null ) {
            throw new IllegalArgumentException("Appointment id must be greater than 0");
        }
    }
}
