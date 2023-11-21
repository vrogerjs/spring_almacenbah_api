package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Unidad;
import regionancash.gob.pe.almacenbah.repository.IUnidadRepository;
import regionancash.gob.pe.almacenbah.service.IUnidadService;

@Service
public class UnidadServiceImpl extends CRUDImpl<Unidad, Integer> implements IUnidadService {

    @Autowired
    private IUnidadRepository repo;

    @Override
    protected JpaRepository<Unidad, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Unidad> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
