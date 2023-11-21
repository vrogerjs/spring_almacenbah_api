package regionancash.gob.pe.almacenbah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.almacenbah.model.Tipocompra;
import regionancash.gob.pe.almacenbah.service.ITipocompraService;

import java.util.List;

@RestController
@RequestMapping("/tipocompra")
public class TipomarcaController {
    @Autowired
    private ITipocompraService service;

    @GetMapping
    public List<Tipocompra> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Tipocompra>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Tipocompra> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Tipocompra readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Tipocompra create(@RequestBody Tipocompra tipocompra) throws Exception {
        return service.create(tipocompra);
    }

    @PutMapping
    public Tipocompra update(@RequestBody Tipocompra tipocompra) throws Exception {
        return service.update(tipocompra);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
