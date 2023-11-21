package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Detalleingreso;
import regionancash.gob.pe.almacenbah.model.Detallesalida;
import regionancash.gob.pe.almacenbah.model.Detallesalida;

import java.util.List;

public interface IDetallesalidaService extends ICRUD<Detallesalida, Integer>{

    Page<Detallesalida> findAllPagination(Pageable page);
    Detallesalida registrarDetalleSalida(Detallesalida detallesalida) throws Exception;

    List<Detallesalida> obtenerDetalleSalida(Integer salidaId);
}
