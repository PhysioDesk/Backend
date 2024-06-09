package physiodesk.physiodesk_backend.Appointments.interfaces.rest.transform;

import physiodesk.physiodesk_backend.Appointments.domain.model.commands.UpdateAppointmentCommand;
import physiodesk.physiodesk_backend.Appointments.interfaces.rest.resources.UpdateAppointmentResource;

public class UpdateAppointmentCommandFromResourceAssembler {
    public static UpdateAppointmentCommand fromResource(Long appointmentId, UpdateAppointmentResource resource) {
        return new UpdateAppointmentCommand(appointmentId, resource.time(), resource.date());
    }
}
