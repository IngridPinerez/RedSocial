package com.makaia.back4.JpaMySql.consumer;

import com.makaia.back4.JpaMySql.services.UsuarioService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    UsuarioService usuarioService;

    @RabbitListener(queues = {"enviar_mensaje"})
    public void receive(@Payload String names) {
        String[] names2 = names.split(",");

        if (names2.length == 2) {
            String emisor = names2[0];
            String receptor = names2[1];

            System.out.println(receptor + ", tienes un nuevo mensaje de " + emisor);
        } else {
            // Handle the case where the expected number of parameters is not received
            System.out.println("Invalid number of parameters received");
        }
    }
}
