package physiodesk.physiodesk_backend.Users.domain.model.entities;
import physiodesk.physiodesk_backend.Users.domain.model.aggregates.physio;

import jakarta.persistence.*;

import java.time.LocalTime;

public class horarios {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "physio_id")
    private physio physio;

    @Column(name = "horario")
    private LocalTime horario;
}
