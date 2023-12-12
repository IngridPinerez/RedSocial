package com.workshop8.redsocial.Mensaje.repositories;

import com.workshop8.redsocial.Mensaje.entities.Mensaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends CrudRepository<Mensaje, Long> {

}
