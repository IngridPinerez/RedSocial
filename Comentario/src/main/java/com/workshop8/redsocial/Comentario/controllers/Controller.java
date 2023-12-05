package com.workshop8.redsocial.Comentario.controllers;

import com.workshop8.redsocial.Comentario.dtos.CrearDTO;
import com.workshop8.redsocial.Comentario.entities.Comentario;
import com.workshop8.redsocial.Comentario.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/comentarios")
public class Controller {
    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping()
    public void crear(@RequestBody CrearDTO dto) {
        this.service.crear(dto);
    }

    @GetMapping()
    public List<Comentario> listar(){
        return  this.service.listar();
    }
}
