package regionancash.gob.pe.almacenbah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.almacenbah.model.Detalleingreso;
import regionancash.gob.pe.almacenbah.model.Lote;
import regionancash.gob.pe.almacenbah.service.IDetalleingresoService;

import java.util.List;

@RestController
@RequestMapping("/detalleingreso")
public class DetalleingresoController {
    @Autowired
    private IDetalleingresoService service;

    @GetMapping
    public List<Detalleingreso> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Detalleingreso>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Detalleingreso> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Detalleingreso readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @GetMapping("/details/{ingresoId}")
    public ResponseEntity<List<Detalleingreso>> obtenerDetallesIngresos(@PathVariable Integer ingresoId) {
        List<Detalleingreso> detalleingresosDisponibles = service.obtenerDetalleIngreso(ingresoId);
        return new ResponseEntity<>(detalleingresosDisponibles, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Detalleingreso> registrarDetalleIngreso(@RequestBody Detalleingreso detalleingreso) {
        /* return service.create(detalleingreso);*/
        try {
            Detalleingreso resultado = service.registrarDetalleIngreso(detalleingreso);
            return new ResponseEntity<>(resultado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public Detalleingreso update(@RequestBody Detalleingreso detalleingreso) throws Exception {
        return service.update(detalleingreso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
