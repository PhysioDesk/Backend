package physiodesk.physiodesk_backend.Appointments.domain.services;

import physiodesk.physiodesk_backend.Appointments.domain.model.aggregates.Appointment;
import physiodesk.physiodesk_backend.Appointments.domain.model.commands.CreateAppointmentCommand;
import physiodesk.physiodesk_backend.Appointments.domain.model.commands.UpdateAppointmentCommand;

import java.util.Optional;

public interface IAppointmentCommandService {

    Optional<Appointment> handle (CreateAppointmentCommand command);
    //todo el profe aqui usa long handle para el create que fue???
    Optional<Appointment> handle(UpdateAppointmentCommand command);
}
