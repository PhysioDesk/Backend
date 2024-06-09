package physiodesk.physiodesk_backend.Appointments.interfaces.rest.resources;

public record AppointmentResource (long id, long patientId, long physiotherapistId, String date, String time) {
}
