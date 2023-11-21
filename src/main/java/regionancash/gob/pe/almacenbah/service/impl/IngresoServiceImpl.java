package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Ingreso;
import regionancash.gob.pe.almacenbah.repository.IIngresoRepository;
import regionancash.gob.pe.almacenbah.service.IIngresoService;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class IngresoServiceImpl extends CRUDImpl<Ingreso, Integer> implements IIngresoService {

    @Autowired
    private IIngresoRepository repo;

    @Override
    protected JpaRepository<Ingreso, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Ingreso> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Optional<Ingreso> obtenerDetallesIngreso(Integer idIngreso) {
        return Optional.ofNullable(repo.findByIdAndActivo(idIngreso, 1));
    }

    @Override
    public Ingreso obtenerPorId(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
