package physiodesk.physiodesk_backend.Appointments.interfaces.rest.transform;

import physiodesk.physiodesk_backend.Appointments.domain.model.commands.CreateAppointmentCommand;
import physiodesk.physiodesk_backend.Appointments.interfaces.rest.resources.CreateAppointmentResource;

public class CreateAppointmentCommandFromResourceAssembler {
    public static CreateAppointmentCommand fromResource(CreateAppointmentResource resource) {
        return new CreateAppointmentCommand(resource.patientId(), resource.physiotherapistId(), resource.date(), resource.time());
    }
}
