package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Lote;

import java.util.List;

public interface ILoteService extends ICRUD<Lote, Integer>{

    Page<Lote> findAllPagination(Pageable page);

    List<Lote> obtenerLotesDisponibles(Integer productoId);

    Lote findById(Integer id);
}
