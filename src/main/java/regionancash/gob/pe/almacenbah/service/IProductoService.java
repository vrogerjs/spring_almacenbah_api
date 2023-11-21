package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Lote;
import regionancash.gob.pe.almacenbah.model.Producto;

public interface IProductoService extends ICRUD<Producto, Integer>{

    Page<Producto> findAllPagination(Pageable page);

    boolean existsByCodigo(String codigo);

    Producto findById(Integer id);
}
