package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Lote;
import regionancash.gob.pe.almacenbah.repository.ILoteRepository;
import regionancash.gob.pe.almacenbah.service.ILoteService;

import java.util.List;
import java.util.Optional;

@Service
public class LoteServiceImpl extends CRUDImpl<Lote, Integer> implements ILoteService {

    @Autowired
    private ILoteRepository repo;

    @Override
    protected JpaRepository<Lote, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Lote> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public List<Lote> obtenerLotesDisponibles(Integer productoId) {
        List<Lote> lotesDisponibles = repo.findLotesDisponiblesByProductoId(productoId);
        return lotesDisponibles;
    }

    @Override
    public Lote findById(Integer id) {
        return repo.findById(id).orElse(null);
    }
}
