package regionancash.gob.pe.almacenbah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.almacenbah.model.Detallesalida;
import regionancash.gob.pe.almacenbah.service.IDetallesalidaService;

import java.util.List;

@RestController
@RequestMapping("/detallesalida")
public class DetallesalidaController {
    @Autowired
    private IDetallesalidaService service;

    @GetMapping
    public List<Detallesalida> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Detallesalida>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Detallesalida> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Detallesalida readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @GetMapping("/details/{salidaId}")
    public ResponseEntity<List<Detallesalida>> obtenerDetallesSalidas(@PathVariable Integer salidaId) {
        List<Detallesalida> detallesalidasDisponibles = service.obtenerDetalleSalida(salidaId);
        return new ResponseEntity<>(detallesalidasDisponibles, HttpStatus.OK);
    }

    @PostMapping("/registrar")
    public ResponseEntity<Detallesalida> registrarDetalleSalida(@RequestBody Detallesalida detallesalida) {
        /* return service.create(detallesalida);*/
        try {
            Detallesalida resultado = service.registrarDetalleSalida(detallesalida);
            return new ResponseEntity<>(resultado, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public Detallesalida create(@RequestBody Detallesalida detallesalida) throws Exception {
        return service.create(detallesalida);
    }

    @PutMapping
    public Detallesalida update(@RequestBody Detallesalida detallesalida) throws Exception {
        return service.update(detallesalida);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
