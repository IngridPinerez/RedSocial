package com.workshop8.redsocial.Comentario.controllers;

import com.workshop8.redsocial.Comentario.dtos.CrearDTO;
import com.workshop8.redsocial.Comentario.entities.Comentario;
import com.workshop8.redsocial.Comentario.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/comentarios")
public class Controller {
    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping()
    public Comentario crear(@RequestBody CrearDTO dto) {
        return this.service.crear(dto);
    }

    @GetMapping()
    public List<Comentario> listar(){
        return  this.service.listar();
    }

    @GetMapping("/comentario/{id}")
    public Optional<Comentario> buscar(@PathVariable("id") Long id) {
        return this.service.buscar(id);
    }

    @PutMapping("/comentario/{id}")
    public Comentario actualizar(@PathVariable("id") Long id, @RequestBody CrearDTO body) {
        return this.service.actualizar(id, body);
    }

    @DeleteMapping("/comentario/{id}")
    public void borrar(@PathVariable("id") Long id) {
        this.service.borrar(id);
    }
}
