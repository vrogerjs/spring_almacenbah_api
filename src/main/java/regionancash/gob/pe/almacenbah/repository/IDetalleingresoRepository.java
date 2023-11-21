package regionancash.gob.pe.almacenbah.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.almacenbah.model.Detalleingreso;
import regionancash.gob.pe.almacenbah.model.Lote;

import java.util.List;

public interface IDetalleingresoRepository extends IGenericRepo<Detalleingreso, Integer>{

    @Query("SELECT di FROM Detalleingreso di where di.ingreso.id= :ingresoId " +
            "AND di.activo = 1 " +
            "AND di.borrado = 0")
    List<Detalleingreso> findDetallesIngresosByIngresoId(@Param("ingresoId") Integer ingresoId);
}
