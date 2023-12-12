package com.workshop8.redsocial.Amistad.controller;

import com.workshop8.redsocial.Amistad.dto.CrearAmistadDTO;
import com.workshop8.redsocial.Amistad.entities.Amistad;
import com.workshop8.redsocial.Amistad.entities.Usuario;
import com.workshop8.redsocial.Amistad.feignClient.IUsuarioFeignClient;
import com.workshop8.redsocial.Amistad.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Amistad crearUsuario(@RequestBody CrearAmistadDTO dto) {
        return this.service.crear(dto);
    }

    @GetMapping()
    public List<Amistad> listarAmistad(){
        return  this.service.listar();
    }

    @GetMapping("/{id}")
    public Amistad getAmistadById(@PathVariable("id") Long id){
        return this.service.getAmistadById(id);
    }

<<<<<<< Updated upstream
=======
    @GetMapping("/validacion/{IdSolicitante}/{IdSolicitado}")
    public Amistad verificarAmistad(@PathVariable("IdSolicitante") Long IdSolicitante,@PathVariable("IdSolicitado") Long IdSolicitado ){
        return this.service.verificarAmistad(IdSolicitante,IdSolicitado);
    }

>>>>>>> Stashed changes
    @PutMapping("/{id}/{respuesta}")
    public Amistad updateAmistad(@PathVariable("id") Long id, @PathVariable("respuesta") String respuesta){
        return this.service.responderAmistad(id,respuesta);
    }


}
