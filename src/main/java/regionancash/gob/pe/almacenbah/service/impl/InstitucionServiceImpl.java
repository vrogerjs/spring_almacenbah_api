package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Institucion;
import regionancash.gob.pe.almacenbah.repository.IInstitucionRepository;
import regionancash.gob.pe.almacenbah.service.IInstitucionService;

@Service
public class InstitucionServiceImpl extends CRUDImpl<Institucion, Integer> implements IInstitucionService {

    @Autowired
    private IInstitucionRepository repo;

    @Override
    protected JpaRepository<Institucion, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Institucion> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
