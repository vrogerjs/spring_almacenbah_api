package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Ingreso;

import java.util.Optional;

public interface IIngresoService extends ICRUD<Ingreso, Integer>{

    Page<Ingreso> findAllPagination(Pageable page);

    Optional<Ingreso> obtenerDetallesIngreso(Integer idIngreso);

    Ingreso obtenerPorId(Integer id);


}
