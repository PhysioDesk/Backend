package physiodesk.physiodesk_backend.Appointments.domain.model.aggregates;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import physiodesk.physiodesk_backend.Appointments.domain.model.commands.CreateAppointmentCommand;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Appointment extends AbstractAggregateRoot {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Column(nullable = false)
    @Getter
    private Long patientId;

    @Column(nullable = false)
    @Getter
    private Long physiotherapistId;

    @Column(nullable = false)
    @Getter
    private String date;

    @Column(nullable = false)
    @Getter

    private String time;

    protected Appointment() {
    }

    public Appointment(CreateAppointmentCommand command) {
        this.patientId = command.patientId();
        this.physiotherapistId = command.physiotherapistId();
        this.date = command.date();
        this.time = command.time();
    }
}

