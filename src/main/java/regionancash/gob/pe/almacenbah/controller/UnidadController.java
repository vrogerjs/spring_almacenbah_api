package regionancash.gob.pe.almacenbah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.almacenbah.model.Unidad;
import regionancash.gob.pe.almacenbah.service.IUnidadService;

import java.util.List;

@RestController
@RequestMapping("/unidad")
public class UnidadController {
    @Autowired
    private IUnidadService service;

    @GetMapping
    public List<Unidad> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Unidad>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Unidad> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Unidad readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Unidad create(@RequestBody Unidad unidad) throws Exception {
        return service.create(unidad);
    }

    @PutMapping
    public Unidad update(@RequestBody Unidad unidad) throws Exception {
        return service.update(unidad);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
