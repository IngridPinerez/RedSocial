package com.workshop8.redsocial.Comentario.repositories;

import com.workshop8.redsocial.Comentario.entities.Mensaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensajeRepository extends CrudRepository<Mensaje, Long> {
}
