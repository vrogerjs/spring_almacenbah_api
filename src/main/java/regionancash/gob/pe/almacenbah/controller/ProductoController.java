package regionancash.gob.pe.almacenbah.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import regionancash.gob.pe.almacenbah.model.Producto;
import regionancash.gob.pe.almacenbah.model.Stock;
import regionancash.gob.pe.almacenbah.repository.IStockRepository;
import regionancash.gob.pe.almacenbah.service.IProductoService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    private IProductoService service;

    @Autowired
    private IStockRepository stockRepository;

    @GetMapping
    public List<Producto> readAll() throws Exception {
        return service.readAll();
    }

    @GetMapping("/stock/{from}/{to}")
    public ResponseEntity<Page<Stock>> getStockWithPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {

        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);

        Page<Stock> stockPage = stockRepository.findAll(pageable);

        // Cargar relaciones de manera explícita para las entidades individuales
        List<Stock> stocks = stockPage.getContent();
        for (Stock stock : stocks) {
            stock.getProducto().getMarca(); // Carga la relación "marca" de Producto
            stock.getProducto().getUnidad(); // Carga la relación "unidad" de Producto
        }

        return ResponseEntity.ok(stockPage);
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<Page<Producto>> findAllPagination(@PathVariable(value = "from") int from, @PathVariable(value = "to") int to) {
        Sort sort = Sort.by(new Sort.Order(Sort.Direction.DESC, "id"));
        var pageable = PageRequest.of(from, to, sort);
        Page<Producto> p = service.findAllPagination(pageable);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Producto readById(@PathVariable("id") Integer id) throws Exception {
        return service.readById(id);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Producto producto) throws Exception {

        String codigo = producto.getCodigo();

        if (codigo != null) {
            if (service.existsByCodigo(codigo)) {
                // Código duplicado, devuelve una respuesta de error
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El codigo ya esta en uso");
            } else {
                // El código no está duplicado, crea el nuevo producto
                Producto createdProducto = service.create(producto);
                return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
            }
        } else {
            Producto createdProducto = service.create(producto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProducto);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> updatePrecio(@PathVariable Integer id, @RequestParam Double precio) {
        Producto existingProducto = service.findById(id);

        if (existingProducto == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            // Actualiza solo el precio del producto
            existingProducto.setPrecio(precio);

            // Llama al método de servicio para actualizar el producto
            Producto updatedProducto = service.update(existingProducto);

            return ResponseEntity.ok(updatedProducto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping
    public Producto update(@RequestBody Producto producto) throws Exception {
        return service.update(producto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
    }
}
