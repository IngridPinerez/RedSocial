package com.workshop8.redsocial.Comentario.repositories;

import com.workshop8.redsocial.Comentario.entities.Comentario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends CrudRepository<Comentario, Long> {
}
