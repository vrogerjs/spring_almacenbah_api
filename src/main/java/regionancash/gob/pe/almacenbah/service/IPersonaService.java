package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Persona;

public interface IPersonaService extends ICRUD<Persona, Integer>{
    Page<Persona> findAllPagination(Pageable page);

    Persona findByNumeroDocumento(String numeroDocumento);
}
