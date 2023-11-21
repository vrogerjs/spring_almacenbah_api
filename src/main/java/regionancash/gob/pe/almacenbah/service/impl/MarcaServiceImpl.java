package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Marca;
import regionancash.gob.pe.almacenbah.repository.IMarcaRepository;
import regionancash.gob.pe.almacenbah.service.IMarcaService;

@Service
public class MarcaServiceImpl extends CRUDImpl<Marca, Integer> implements IMarcaService {

    @Autowired
    private IMarcaRepository repo;

    @Override
    protected JpaRepository<Marca, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Marca> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }
}
