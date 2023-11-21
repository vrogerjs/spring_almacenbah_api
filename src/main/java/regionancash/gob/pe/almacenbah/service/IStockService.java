package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Stock;

public interface IStockService extends ICRUD<Stock, Integer>{

    Page<Stock> findAllPagination(Pageable page);

    Stock findStockByProductoId(Integer productoId);
}
