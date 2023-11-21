package regionancash.gob.pe.almacenbah.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import regionancash.gob.pe.almacenbah.model.Stock;

import java.util.List;

public interface IStockRepository extends IGenericRepo<Stock, Integer>{
    Page<Stock> findAll(Pageable pageable);

    Stock findByProductoId(Integer productoId);
}
