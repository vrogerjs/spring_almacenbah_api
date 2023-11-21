package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Detalleingreso;
import regionancash.gob.pe.almacenbah.model.Lote;

import java.util.List;

public interface IDetalleingresoService extends ICRUD<Detalleingreso, Integer>{

    Page<Detalleingreso> findAllPagination(Pageable page);

    Detalleingreso registrarDetalleIngreso(Detalleingreso detalleingreso) throws Exception;

    List<Detalleingreso> obtenerDetalleIngreso(Integer ingresoId);
}
