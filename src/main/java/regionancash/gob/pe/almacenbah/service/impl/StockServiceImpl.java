package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Stock;
import regionancash.gob.pe.almacenbah.repository.IStockRepository;
import regionancash.gob.pe.almacenbah.service.IStockService;

@Service
public class StockServiceImpl extends CRUDImpl<Stock, Integer> implements IStockService {

    @Autowired
    private IStockRepository repo;

    @Override
    protected JpaRepository<Stock, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Stock> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Stock findStockByProductoId(Integer productoId) {
        return repo.findByProductoId(productoId);
    }
}
