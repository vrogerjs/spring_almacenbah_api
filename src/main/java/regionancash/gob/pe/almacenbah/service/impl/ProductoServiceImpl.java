package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Lote;
import regionancash.gob.pe.almacenbah.model.Producto;
import regionancash.gob.pe.almacenbah.repository.IProductoRepository;
import regionancash.gob.pe.almacenbah.service.IProductoService;

@Service
public class ProductoServiceImpl extends CRUDImpl<Producto, Integer> implements IProductoService {

    @Autowired
    private IProductoRepository repo;

    @Override
    protected JpaRepository<Producto, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Producto> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public boolean existsByCodigo(String codigo) {
        return repo.existsByCodigo(codigo);
    }

    @Override
    public Producto findById(Integer id) {
        return repo.findById(id).orElse(null);
    }

}
