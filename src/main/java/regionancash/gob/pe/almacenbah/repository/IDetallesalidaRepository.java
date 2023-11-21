package regionancash.gob.pe.almacenbah.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.almacenbah.model.Detalleingreso;
import regionancash.gob.pe.almacenbah.model.Detallesalida;

import java.util.List;

public interface IDetallesalidaRepository extends IGenericRepo<Detallesalida, Integer>{
    @Query("SELECT ds FROM Detallesalida ds where ds.salida.id= :salidaId " +
            "AND ds.activo = 1 " +
            "AND ds.borrado = 0")
    List<Detallesalida> findDetallesSalidasBySalidaId(@Param("salidaId") Integer salidaId);
}
