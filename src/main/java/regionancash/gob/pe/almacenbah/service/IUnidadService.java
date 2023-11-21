package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Unidad;

public interface IUnidadService extends ICRUD<Unidad, Integer>{

    Page<Unidad> findAllPagination(Pageable page);
}
