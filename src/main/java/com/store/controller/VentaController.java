package com.store.controller;

import com.store.exception.ModeloNotFoundException;
import com.store.model.Venta;
import com.store.service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private IVentaService service;

    @GetMapping
    public ResponseEntity<List<Venta>> listar() throws Exception{
        List<Venta> lista = service.listar();
        return new ResponseEntity<List<Venta>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venta> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Venta obj = service.listarPorId(id);
        if (obj == null) {
            throw new ModeloNotFoundException("ID no existe: "+ id);
        }
        return new ResponseEntity<Venta>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody Venta venta) throws Exception {
        Venta obj = service.registrarTransaccional(venta);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getIdVenta()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Venta> modificar(@Valid @RequestBody Venta venta) throws Exception {
        Venta obj = service.registrar(venta);

        return new ResponseEntity<Venta>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id]")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Venta obj = service.listarPorId(id);
        if (obj.getIdVenta() == null) {
            throw new ModeloNotFoundException("ID no existe: "+ id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
