package regionancash.gob.pe.almacenbah.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import regionancash.gob.pe.almacenbah.model.Ingreso;
import regionancash.gob.pe.almacenbah.model.Lote;

import java.util.List;

public interface IIngresoRepository extends IGenericRepo<Ingreso, Integer>{
    Ingreso findByIdAndActivo(Integer id, Integer activo);


}
