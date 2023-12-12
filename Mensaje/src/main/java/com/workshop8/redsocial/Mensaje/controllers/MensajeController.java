package com.workshop8.redsocial.Mensaje.controllers;

import com.workshop8.redsocial.Mensaje.dtos.CrearMensajeDTO;
import com.workshop8.redsocial.Mensaje.entities.Mensaje;
import com.workshop8.redsocial.Mensaje.services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/mensaje")
public class MensajeController {
    private MensajeService service;

    @Autowired
    public MensajeController(MensajeService service){
        this.service = service;
    }

    @PostMapping
    public Mensaje enviar(@RequestBody CrearMensajeDTO dto){
        return this.service.enviar(dto);
    }

    @GetMapping()
    public List<Mensaje> listarMensajes(){
        return  this.service.listar();
    }

}
