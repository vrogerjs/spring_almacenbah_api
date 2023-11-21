package regionancash.gob.pe.almacenbah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.almacenbah.model.Stock;
import regionancash.gob.pe.almacenbah.service.IStockService;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private IStockService service;

    @GetMapping
    public List<Stock> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Stock>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Stock> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Stock readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @GetMapping("/producto/{idProducto}")
    public ResponseEntity<Stock> getStockByProductoId(@PathVariable Integer idProducto) {
        Stock stock = service.findStockByProductoId(idProducto);

        if (stock == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(stock);
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock) throws Exception {
        return service.create(stock);
    }

    @PutMapping
    public Stock update(@RequestBody Stock stock) throws Exception {
        return service.update(stock);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
