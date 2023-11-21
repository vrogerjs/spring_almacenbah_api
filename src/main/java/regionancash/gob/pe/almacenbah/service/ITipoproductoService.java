package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Tipoproducto;

public interface ITipoproductoService extends ICRUD<Tipoproducto, Integer>{

    Page<Tipoproducto> findAllPagination(Pageable page);
}
