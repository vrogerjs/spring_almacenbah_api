package regionancash.gob.pe.almacenbah.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.almacenbah.model.Lote;

import java.util.List;

public interface ILoteRepository extends IGenericRepo<Lote, Integer>{
    @Query("SELECT l FROM Lote l " +
            "INNER JOIN l.detalleingreso di " +
            "WHERE di.producto.id = :productoId " +
            "AND l.cantidad > cantidadReal " +
            "AND l.activo = 1 " +
            "AND l.borrado = 0")
    List<Lote> findLotesDisponiblesByProductoId(@Param("productoId") Integer productoId);
}
