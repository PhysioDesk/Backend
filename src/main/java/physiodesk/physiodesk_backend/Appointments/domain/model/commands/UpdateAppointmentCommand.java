package physiodesk.physiodesk_backend.Appointments.domain.model.commands;

public record UpdateAppointmentCommand(Long id, String date, String time) {
}
