package regionancash.gob.pe.almacenbah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.almacenbah.model.Ingreso;
import regionancash.gob.pe.almacenbah.service.IIngresoService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {
    @Autowired
    private IIngresoService service;

    @GetMapping
    public List<Ingreso> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Ingreso>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Ingreso> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Ingreso readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    /*@GetMapping("/details/{idIngreso}")
    public ResponseEntity<Ingreso> obtenerDetallesIngreso(@PathVariable Integer idIngreso) {
        Optional<Ingreso> optionalIngreso = service.obtenerDetallesIngreso(idIngreso);

        return optionalIngreso
                .map(ingreso -> new ResponseEntity<>(ingreso, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }*/

    @GetMapping("/details/{id}")
    public Ingreso obtenerIngresoPorId(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    @PostMapping
    public Ingreso create(@RequestBody Ingreso ingreso) throws Exception {
        return service.create(ingreso);
    }

    @PutMapping
    public Ingreso update(@RequestBody Ingreso ingreso) throws Exception {
        return service.update(ingreso);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
