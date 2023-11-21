package regionancash.gob.pe.almacenbah.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import regionancash.gob.pe.almacenbah.model.Notificacion;

import java.time.LocalTime;

public interface INotificacionService extends ICRUD<Notificacion, Integer>{
    Page<Notificacion> findAllPagination(Pageable page);

    Page<Notificacion> findAllByEstado(Pageable page, String estado, Integer uid);

    int changeEstado(Integer id, String estado);

    int changeRecepcion(Integer id, LocalTime horaRecepcion);

}
