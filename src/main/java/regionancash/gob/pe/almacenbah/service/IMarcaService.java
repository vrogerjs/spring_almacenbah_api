package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Marca;

public interface IMarcaService extends ICRUD<Marca, Integer>{

    Page<Marca> findAllPagination(Pageable page);
}
