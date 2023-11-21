package regionancash.gob.pe.almacenbah.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductoStockDTO {
    private Integer productoId;
    private String codigo;
    private String nombre;
    private Double cantidadDisponible;
    private String marca;
    private String unidad;

    public ProductoStockDTO(Integer productoId, String codigo, String nombre, Double cantidadDisponible, String marca, String unidad) {
        this.productoId = productoId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadDisponible = cantidadDisponible;
        this.marca = marca;
        this.unidad = unidad;
    }
}
