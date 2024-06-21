package physiodesk.physiodesk_backend.Users.domain.model.aggregates;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import physiodesk.physiodesk_backend.Users.domain.model.commands.physio.CreatePhysioCommand;

import java.time.LocalTime;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class physio extends AbstractAggregateRoot<physio> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false)
    @Getter
    @JsonProperty("fullName")
    @Setter
    private String nombre;

    @Column(nullable = false)
    @Getter
    @Setter
    private String imagen;

    @Column(nullable = false)
    @Getter
    @Setter
    private String biografia;

    @Column(nullable = false)
    @Getter
    @Setter
    private Short edad;

    @ElementCollection
    @CollectionTable(name = "physio_horarios", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "horario")
    @Setter
    @Getter
    private List<LocalTime> horarios;

    public physio(){
    }

    public physio(Long id, String nombre, String imagen,  String biografia, Short edad, List<LocalTime> horarios) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.biografia = biografia;
        this.edad = edad;
        this.horarios = horarios;
    }

    public physio(CreatePhysioCommand command){
        this.nombre = command.nombre();
        this.imagen = command.imagen();
        this.biografia = command.biografia();
        this.edad = command.edad();
        this.horarios = command.horarios();
    }
}
