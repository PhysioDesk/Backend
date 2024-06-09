package physiodesk.physiodesk_backend.Appointments.interfaces.rest.transform;

import physiodesk.physiodesk_backend.Appointments.domain.model.aggregates.Appointment;
import physiodesk.physiodesk_backend.Appointments.interfaces.rest.resources.AppointmentResource;

public class AppointmentResourceFromEntityAssembler {

    public static AppointmentResource fromEntity(Appointment appointment) {
        return new AppointmentResource(appointment.getId(), appointment.getPatientId(), appointment.getPhysiotherapistId(), appointment.getDate(), appointment.getTime());
    }
}
