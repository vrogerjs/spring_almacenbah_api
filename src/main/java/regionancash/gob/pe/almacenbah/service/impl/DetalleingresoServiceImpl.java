package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Detalleingreso;
import regionancash.gob.pe.almacenbah.model.Lote;
import regionancash.gob.pe.almacenbah.model.Stock;
import regionancash.gob.pe.almacenbah.repository.IDetalleingresoRepository;
import regionancash.gob.pe.almacenbah.repository.IStockRepository;
import regionancash.gob.pe.almacenbah.service.IDetalleingresoService;

import java.util.List;

@Service
public class DetalleingresoServiceImpl extends CRUDImpl<Detalleingreso, Integer> implements IDetalleingresoService {

    @Autowired
    private IDetalleingresoRepository repo;
    @Autowired
    private IStockRepository repostock;

    @Override
    protected JpaRepository<Detalleingreso, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Detalleingreso> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Detalleingreso registrarDetalleIngreso(Detalleingreso detalleingreso) throws Exception {
        // Realiza las validaciones necesarias, por ejemplo, asegúrate de que la cantidad sea válida
        if (detalleingreso.getCantidad() <= 0) {
            throw new Exception("La cantidad debe ser mayor que cero");
        }

        // Obtiene el stock correspondiente al detalle de ingreso
        Stock stock = repostock.findById(detalleingreso.getProducto().getId()).orElse(null);
        if (stock == null) {
            throw new Exception("El stock no existe");
        }

        if(detalleingreso.getCostoTotal() == 0){
            stock.setCantidadSinprecio(stock.getCantidadSinprecio() + detalleingreso.getCantidad());
        }else{
            stock.setCantidadConprecio(stock.getCantidadConprecio() + detalleingreso.getCantidad());
        }

        // Actualiza la cantidad en el stock sumando la cantidad del detalle de ingreso
        stock.setCantidadDisponible(stock.getCantidadDisponible() + detalleingreso.getCantidad());

        // Guarda el detalle de ingreso
        Detalleingreso resultado = repo.save(detalleingreso);

        // Guarda el stock actualizado en la base de datos
        repostock.save(stock);

        return resultado;
    }

    @Override
    public List<Detalleingreso> obtenerDetalleIngreso(Integer ingresoId) {
        List<Detalleingreso> detalleIngresos = repo.findDetallesIngresosByIngresoId(ingresoId);
        return detalleIngresos;
    }
}
