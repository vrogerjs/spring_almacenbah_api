package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Institucion;

public interface IInstitucionService extends ICRUD<Institucion, Integer>{

    Page<Institucion> findAllPagination(Pageable page);
}
