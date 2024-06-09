package physiodesk.physiodesk_backend.Appointments.domain.services;

import physiodesk.physiodesk_backend.Appointments.domain.model.aggregates.Appointment;
import physiodesk.physiodesk_backend.Appointments.domain.model.queries.GetAllAppointmentsByPatientIdQuery;
import physiodesk.physiodesk_backend.Appointments.domain.model.queries.GetAllAppointmentsByPhysiotherapistIdQuery;
import physiodesk.physiodesk_backend.Appointments.domain.model.queries.GetAllByPhysiotherapistIdAndDateQuery;
import physiodesk.physiodesk_backend.Appointments.domain.model.queries.GetAppointmentByIdQuery;

import java.util.List;
import java.util.Optional;

public interface IAppointmentQueryService {

    List<Appointment> handle(GetAllAppointmentsByPhysiotherapistIdQuery query);

    Optional<Appointment> handle(GetAppointmentByIdQuery query);

    List<Appointment> handle(GetAllAppointmentsByPatientIdQuery query);

    List<Appointment> handle(GetAllByPhysiotherapistIdAndDateQuery query);
}
