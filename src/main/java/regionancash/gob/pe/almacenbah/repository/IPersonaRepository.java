package regionancash.gob.pe.almacenbah.repository;

import regionancash.gob.pe.almacenbah.model.Persona;

public interface IPersonaRepository extends IGenericRepo<Persona, Integer>{
    Persona findByNroDocumento(String numeroDocumento);
}
