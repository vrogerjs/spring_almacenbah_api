package regionancash.gob.pe.almacenbah.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "ingresos")
public class Ingreso {
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
    private String atencion;

    @Column(columnDefinition = "TEXT")
    private String destino;

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
    @JoinColumn(name="proveedor_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Proveedor proveedor;

    @ManyToOne
    @JoinColumn(name="tipocompra_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Tipocompra tipocompra;

    @JsonIgnore
    @OneToMany(mappedBy="ingreso")
    private Set<Detalleingreso> detalleingresos;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date updatedAt;

}
