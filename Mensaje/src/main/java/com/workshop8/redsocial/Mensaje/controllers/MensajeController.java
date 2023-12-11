package com.workshop8.redsocial.Mensaje.controllers;

import com.workshop8.redsocial.Mensaje.services.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mensaje")
public class MensajeController {
    private MensajeService service;

    @Autowired
    public MensajeController(MensajeService service){
        this.service = service;
    }


}
