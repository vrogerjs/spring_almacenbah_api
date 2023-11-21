package regionancash.gob.pe.almacenbah.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@ToString
@Entity
@Table(name = "unidads")
public class Unidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 512)
    private String nombre;

    @Column(nullable = false, length = 32)
    private String cantidad;

    @Column(length = 32)
    private String abreviatura;

    @Column(nullable = false, length = 1)
    private Integer tipo;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer activo=1;

    @Column(nullable = false, length = 1)
    @Builder.Default
    private Integer borrado=0;

    @JsonIgnore
    @OneToMany(mappedBy="unidad")
    private Set<Producto> productos;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date createdAt;

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = true)
    private Date updatedAt;

}
