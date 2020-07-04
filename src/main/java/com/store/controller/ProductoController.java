package com.store.controller;

import com.store.exception.ModeloNotFoundException;
import com.store.model.Producto;
import com.store.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService service;

    @GetMapping
    public ResponseEntity<List<Producto>> listar() throws Exception{
        List<Producto> lista = service.listar();
        return new ResponseEntity<List<Producto>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Producto obj = service.listarPorId(id);
        if (obj == null) {
            throw new ModeloNotFoundException("ID no existe: "+ id);
        }
        return new ResponseEntity<Producto>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody Producto producto) throws Exception {
        Producto obj = service.registrar(producto);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdProducto()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Producto> modificar(@Valid @RequestBody Producto producto) throws Exception {
        Producto obj = service.registrar(producto);

        return new ResponseEntity<Producto>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id]")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Producto obj = service.listarPorId(id);
        if (obj.getIdProducto() == null) {
            throw new ModeloNotFoundException("ID no existe: "+ id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
