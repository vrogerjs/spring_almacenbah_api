package regionancash.gob.pe.almacenbah.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "notificacions")
public class Notificacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 16)
    private String nroNotificacion;

    @Column(nullable = false, length = 16)
    private String nroExpediente;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String asunto;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false, length = 16)
    private String folios;

    @Column(nullable = false, length = 2048)
    private String urlDocumento;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(nullable = false, columnDefinition = "TIME")
    private LocalTime horaEmision;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    @Column(columnDefinition = "TIME")
    private LocalTime horaRecepcion;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate fechaRegistro;

    @Column(nullable = false, length = 1024)
    private String remitente;



    /*@ManyToOne
    @JoinColumn(name="remitente_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Remitente remitente;

    @ManyToOne
    @JoinColumn(name="destinatario_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Destinatario destinatario;*/

    @ManyToOne
    @JoinColumn(name="persona_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Persona persona;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer estado=1;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer activo=1;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer borrado=0;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

}
