package com.workshop8.redsocial.Comentario.consumer;

import com.workshop8.redsocial.Comentario.dtos.CrearDTO;
import com.workshop8.redsocial.Comentario.services.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    Service comentarioService;

    @RabbitListener(queues = {"post_created"}) // comment_created: Nombre de la cola que se quiere escuchar
    public void receive(@Payload String ids) {
        String[] ids2 = ids.split(",");

        if (ids2.length == 2) {
            Long idUsuario = Long.parseLong(ids2[0]);
            Long idPublicacion = Long.parseLong(ids2[1]);

            System.out.println("Crear un comentario en la publicacion " + idPublicacion + " para el usuario " + idUsuario);
            CrearDTO defaultP = new CrearDTO("Comentario por defecto", idUsuario, idPublicacion);
            this.comentarioService.crear(defaultP);
        } else {
            // Handle the case where the expected number of parameters is not received
            System.out.println("Invalid number of parameters received");
        }
    }
}
