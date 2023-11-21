package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Salida;

public interface ISalidaService extends ICRUD<Salida, Integer>{

    Page<Salida> findAllPagination(Pageable page);
}
