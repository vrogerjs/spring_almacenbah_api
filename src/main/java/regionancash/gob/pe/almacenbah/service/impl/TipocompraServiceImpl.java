package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Tipocompra;
import regionancash.gob.pe.almacenbah.repository.ITipocompraRepository;
import regionancash.gob.pe.almacenbah.service.ITipocompraService;

@Service
public class TipocompraServiceImpl extends CRUDImpl<Tipocompra, Integer> implements ITipocompraService {

    @Autowired
    private ITipocompraRepository repo;

    @Override
    protected JpaRepository<Tipocompra, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Tipocompra> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
