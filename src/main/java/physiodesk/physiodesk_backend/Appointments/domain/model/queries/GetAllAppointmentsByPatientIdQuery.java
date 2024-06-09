package physiodesk.physiodesk_backend.Appointments.domain.model.queries;

public record GetAllAppointmentsByPatientIdQuery(Long patientId) {
    public GetAllAppointmentsByPatientIdQuery {
        if (patientId == null) {
            throw new IllegalArgumentException("Patient id must be greater than 0");
        }
    }
}
