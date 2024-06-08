package physiodesk.physiodesk_backend.Appointments.application.internal.commandservices;

import org.springframework.stereotype.Service;
import physiodesk.physiodesk_backend.Appointments.domain.model.aggregates.Appointment;
import physiodesk.physiodesk_backend.Appointments.domain.model.commands.CreateAppointmentCommand;
import physiodesk.physiodesk_backend.Appointments.domain.services.IAppointmentCommandService;
import physiodesk.physiodesk_backend.Appointments.infrastructure.persistance.jpa.IAppointmentRepository;

import java.util.Optional;

@Service
public class AppointmentCommandServiceImpl implements IAppointmentCommandService {

    private final IAppointmentRepository appointmentRepository;

    public AppointmentCommandServiceImpl(IAppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public Optional<Appointment> handle(CreateAppointmentCommand command) {
        if(appointmentRepository.existsByPatientIdAndPhysiotherapistIdAndDate(command.patientId(), command.physiotherapistId(), command.date())){
            throw new IllegalArgumentException("Appointment already exists");
        }
        var appointment = new Appointment(command);
        var savedAppointment = appointmentRepository.save(appointment);
        return Optional.of(savedAppointment);
    }
}
