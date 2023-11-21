package regionancash.gob.pe.almacenbah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.almacenbah.model.Lote;
import regionancash.gob.pe.almacenbah.service.ILoteService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/lote")
public class LoteController {
    @Autowired
    private ILoteService service;

    @GetMapping
    public List<Lote> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/disponibles/{productoId}")
    public ResponseEntity<List<Lote>> obtenerLotesDisponibles(@PathVariable Integer productoId) {
        List<Lote> lotesDisponibles = service.obtenerLotesDisponibles(productoId);
        return new ResponseEntity<>(lotesDisponibles, HttpStatus.OK);
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Lote>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Lote> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping("/{id}/actualizarCantidadReal")
    public ResponseEntity<Lote> actualizarCantidadReal(@PathVariable Integer id, @RequestParam Integer cantidadReal) {
        Lote existingLote = service.findById(id);

        if (existingLote == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            existingLote.setCantidadReal(cantidadReal);
            existingLote.setUpdatedAt(new Date());

            Lote updatedLote = service.update(existingLote);

            return ResponseEntity.ok(updatedLote);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public Lote readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public Lote create(@RequestBody Lote lote) throws Exception {
        return service.create(lote);
    }

    @PutMapping
    public Lote update(@RequestBody Lote lote) throws Exception {
        return service.update(lote);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
