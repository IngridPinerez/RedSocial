package com.workshop8.redsocial.Mensaje.publisher;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublisherConfig {
    @Value("${redSocial.rabbit.queue.enviarMensaje}")
    private String name;

    @Bean
    public Queue queue() {
        return new Queue(this.name);
    }

}

