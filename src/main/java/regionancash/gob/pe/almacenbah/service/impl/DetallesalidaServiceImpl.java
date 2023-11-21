package regionancash.gob.pe.almacenbah.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import regionancash.gob.pe.almacenbah.model.Detalleingreso;
import regionancash.gob.pe.almacenbah.model.Detallesalida;
import regionancash.gob.pe.almacenbah.model.Detallesalida;
import regionancash.gob.pe.almacenbah.model.Stock;
import regionancash.gob.pe.almacenbah.repository.IDetallesalidaRepository;
import regionancash.gob.pe.almacenbah.repository.IStockRepository;
import regionancash.gob.pe.almacenbah.service.IDetallesalidaService;

import java.util.List;

@Service
public class DetallesalidaServiceImpl extends CRUDImpl<Detallesalida, Integer> implements IDetallesalidaService {

    @Autowired
    private IDetallesalidaRepository repo;

    @Autowired
    private IStockRepository repostock;
    
    @Override
    protected JpaRepository<Detallesalida, Integer> getRepo() {
        return repo;
    }

    @Override
    public Page<Detallesalida> findAllPagination(Pageable page) {
        return repo.findAll(page);
    }

    @Override
    public Detallesalida registrarDetalleSalida(Detallesalida detallesalida) throws Exception {
        // Realiza las validaciones necesarias, por ejemplo, asegúrate de que la cantidad sea válida
        if (detallesalida.getCantidad() <= 0) {
            throw new Exception("La cantidad debe ser mayor que cero");
        }

        // Obtiene el stock correspondiente al detalle de ingreso
        Stock stock = repostock.findById(detallesalida.getProducto().getId()).orElse(null);
        if (stock == null) {
            throw new Exception("El stock no existe");
        }

        if(detallesalida.getCostoTotal() == 0){
            stock.setCantidadSinprecio(stock.getCantidadSinprecio() - detallesalida.getCantidad());
        }else{
            stock.setCantidadConprecio(stock.getCantidadConprecio() - detallesalida.getCantidad());
        }

        // Actualiza la cantidad en el stock sumando la cantidad del detalle de ingreso
        stock.setCantidadDisponible(stock.getCantidadDisponible() - detallesalida.getCantidad());

        // Guarda el detalle de ingreso
        Detallesalida resultado = repo.save(detallesalida);

        // Guarda el stock actualizado en la base de datos
        repostock.save(stock);

        return resultado;
    }

    @Override
    public List<Detallesalida> obtenerDetalleSalida(Integer salidaId) {
        List<Detallesalida> detalleSalidas = repo.findDetallesSalidasBySalidaId(salidaId);
        return detalleSalidas;
    }
}
