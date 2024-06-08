package physiodesk.physiodesk_backend.Appointments.domain.services;

import physiodesk.physiodesk_backend.Appointments.domain.model.aggregates.Appointment;
import physiodesk.physiodesk_backend.Appointments.domain.model.commands.CreateAppointmentCommand;

import java.util.Optional;

public interface IAppointmentCommandService {

    Optional<Appointment> handle (CreateAppointmentCommand command);
}
