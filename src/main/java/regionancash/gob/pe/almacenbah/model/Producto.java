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
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 32)
    private String codigo;

    @Column(nullable = false, length = 1024)
    private String nombre;

    @Column
    @Builder.Default
    private Double precio = 0.00;

    @ManyToOne
    @JoinColumn(name="marca_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Marca marca;

    @ManyToOne
    @JoinColumn(name="unidad_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Unidad unidad;

    @ManyToOne
    @JoinColumn(name="tipoproducto_id", nullable=false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    //@JsonIgnore
    private Tipoproducto tipoproducto;

    @JsonIgnore
    @OneToMany(mappedBy="producto")
    private Set<Stock> stocks;

    @JsonIgnore
    @OneToMany(mappedBy="producto")
    private Set<Detallesalida> detallesalidas;

    @JsonIgnore
    @OneToMany(mappedBy="producto")
    private Set<Detalleingreso> detalleingresos;

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
