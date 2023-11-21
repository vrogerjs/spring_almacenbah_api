package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Proveedor;
import regionancash.gob.pe.almacenbah.repository.IProveedorRepository;
import regionancash.gob.pe.almacenbah.service.IProveedorService;

@Service
public class ProveedorServiceImpl extends CRUDImpl<Proveedor, Integer> implements IProveedorService {

    @Autowired
    private IProveedorRepository repo;

    @Override
    protected JpaRepository<Proveedor, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Proveedor> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
