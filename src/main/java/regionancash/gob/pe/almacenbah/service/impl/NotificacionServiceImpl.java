package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Notificacion;
import regionancash.gob.pe.almacenbah.repository.INotificacionRepository;
import regionancash.gob.pe.almacenbah.service.INotificacionService;

import java.time.LocalTime;

@Service
public class NotificacionServiceImpl extends CRUDImpl<Notificacion, Integer> implements INotificacionService {

    @Autowired
    private INotificacionRepository repo;

    @Override
    protected JpaRepository<Notificacion, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Notificacion> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    public int changeEstado(Integer id, String estado) {
        return repo.changeEstadoOne(id, estado);
    }

    @Override
    public Page<Notificacion> findAllByEstado(Pageable page, String estado, Integer uid) {
        return repo.findAllByEstado(page, estado, uid);
    }

    @Override
    public int changeRecepcion(Integer id, LocalTime horaRecepcion) {
        return repo.changeRecepcion(id, horaRecepcion);
    }
}
