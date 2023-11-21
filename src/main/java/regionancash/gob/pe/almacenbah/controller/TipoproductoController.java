package regionancash.gob.pe.almacenbah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.almacenbah.model.Tipoproducto;
import regionancash.gob.pe.almacenbah.service.ITipoproductoService;

import java.util.List;

@RestController
@RequestMapping("/tipoproducto")
public class TipoproductoController {
    @Autowired
    private ITipoproductoService service;

    @GetMapping
    public List<Tipoproducto> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Tipoproducto>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Tipoproducto> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Tipoproducto readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Tipoproducto create(@RequestBody Tipoproducto tipoproducto) throws Exception {
        return service.create(tipoproducto);
    }

    @PutMapping
    public Tipoproducto update(@RequestBody Tipoproducto tipoproducto) throws Exception {
        return service.update(tipoproducto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
