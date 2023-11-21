package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Proveedor;

public interface IProveedorService extends ICRUD<Proveedor, Integer>{

    Page<Proveedor> findAllPagination(Pageable page);
}
