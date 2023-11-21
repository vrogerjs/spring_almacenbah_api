package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Salida;
import regionancash.gob.pe.almacenbah.repository.ISalidaRepository;
import regionancash.gob.pe.almacenbah.service.ISalidaService;

@Service
public class SalidaServiceImpl extends CRUDImpl<Salida, Integer> implements ISalidaService {

    @Autowired
    private ISalidaRepository repo;

    @Override
    protected JpaRepository<Salida, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Salida> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
