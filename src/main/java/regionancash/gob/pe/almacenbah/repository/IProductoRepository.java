package regionancash.gob.pe.almacenbah.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.crossstore.ChangeSetPersister;
import regionancash.gob.pe.almacenbah.model.Producto;

public interface IProductoRepository extends IGenericRepo<Producto, Integer>{
    boolean existsByCodigo(String codigo);

}
