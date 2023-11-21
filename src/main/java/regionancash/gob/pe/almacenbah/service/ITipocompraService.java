package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Tipocompra;

public interface ITipocompraService extends ICRUD<Tipocompra, Integer>{

    Page<Tipocompra> findAllPagination(Pageable page);
}
