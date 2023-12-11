package com.workshop8.redsocial.Mensaje.repositories;

import com.workshop8.redsocial.Mensaje.entities.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface MensajeRepository extends CrudRepository<Mensaje, Long> {

}
