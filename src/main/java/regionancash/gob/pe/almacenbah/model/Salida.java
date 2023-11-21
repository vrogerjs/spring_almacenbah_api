package regionancash.gob.pe.almacenbah.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "salidas")
public class Salida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 16)
    private String numero;

    @Column(nullable = false, length = 16)
    private Date fecha;

    @Column(nullable = false, length = 8)
    private Integer anio;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(nullable = false)
    private Double costoTotal;

    @Column(columnDefinition = "TEXT")
    private String solicitante;

    @Column(columnDefinition = "TEXT")
    private String referencia;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer activo=1;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer borrado=0;

    @ManyToOne
    @JoinColumn(name="institucion_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Institucion institucion;

    @ManyToOne
    @JoinColumn(name="persona_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Persona persona;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date updatedAt;

}
