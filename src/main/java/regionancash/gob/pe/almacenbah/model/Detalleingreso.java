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
@Table(name = "detalleingresos")
public class Detalleingreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Double cantidad;

    @Column(nullable = false)
    private Double costoUnitario;

    @Column(nullable = false)
    private Double costoTotal;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer activo=1;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer borrado=0;

    @ManyToOne
    @JoinColumn(name="ingreso_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Ingreso ingreso;

    @ManyToOne
    @JoinColumn(name="producto_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Producto producto;

    @JsonIgnore
    @OneToMany(mappedBy="detalleingreso")
    private Set<Lote> lotes;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date updatedAt;

}
