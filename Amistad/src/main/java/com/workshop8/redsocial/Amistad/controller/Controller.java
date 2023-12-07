package com.workshop8.redsocial.Amistad.controller;

import com.workshop8.redsocial.Amistad.dto.CrearDTO;
import com.workshop8.redsocial.Amistad.entities.Amistad;
import com.workshop8.redsocial.Amistad.entities.Usuario;
import com.workshop8.redsocial.Amistad.feignClient.IUsuarioFeignClient;
import com.workshop8.redsocial.Amistad.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/amistad")
public class Controller {

    @Autowired
    private IUsuarioFeignClient iUsuarioFeignClient;
    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @PostMapping()
    public Amistad crearUsuario(@RequestBody CrearDTO dto) {
        return this.service.crear(dto);
    }

    @GetMapping()
    public List<Amistad> listarAmistad(){
        return  this.service.listar();
    }

    @GetMapping("/amistad/{id}")
    public Usuario getUsuarioById(@PathVariable("id") Long id){
        return this.iUsuarioFeignClient.getUsuarioById(id);
    }

    @GetMapping("/{id}")
    public Amistad getAmistadById(@PathVariable("id") Long id){
        return this.service.getAmistadById(id);
    }



}