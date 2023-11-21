package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Tipoproducto;
import regionancash.gob.pe.almacenbah.repository.ITipoproductoRepository;
import regionancash.gob.pe.almacenbah.service.ITipoproductoService;

@Service
public class TipoproductoServiceImpl extends CRUDImpl<Tipoproducto, Integer> implements ITipoproductoService {

    @Autowired
    private ITipoproductoRepository repo;

    @Override
    protected JpaRepository<Tipoproducto, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Tipoproducto> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
