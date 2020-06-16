package com.store.controller;

import com.store.exception.ModeloNotFoundException;
import com.store.model.Persona;
import com.store.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public ResponseEntity<List<Persona>> listar() throws Exception{
        List<Persona> lista = service.listar();
        return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Persona> listarPorId(@PathVariable("id") Integer id) throws Exception {
        Persona obj = service.listarPorId(id);
        if (obj == null) {
            throw new ModeloNotFoundException("ID no existe: "+ id);
        }
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> registrar(@Valid @RequestBody Persona persona) throws Exception {
        Persona obj = service.registrar(persona);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getIdPersona()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Persona> modificar(@Valid @RequestBody Persona persona) throws Exception {
        Persona obj = service.registrar(persona);

        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @DeleteMapping("/{id]")
    public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception {
        Persona obj = service.listarPorId(id);
        if (obj.getIdPersona() == null) {
            throw new ModeloNotFoundException("ID no existe: "+ id);
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
