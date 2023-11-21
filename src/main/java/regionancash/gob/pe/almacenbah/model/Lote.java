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
@Table(name = "lotes")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 512)
    private String nombre;

    @Column(nullable = false, length = 16)
    private Date fecharegistro;

    @Column(length = 16)
    private Date fechavencimiento;

    @Column(nullable = false)
    private Integer cantidad;

    @Column
    @Builder.Default
    private Integer cantidadReal=0;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer activo=1;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer borrado=0;

    @JsonIgnore
    @OneToMany(mappedBy="lote")
    private Set<Detallesalida> detallesalidas;

    @ManyToOne
    @JoinColumn(name="detalleingreso_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Detalleingreso detalleingreso;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date updatedAt;

}
