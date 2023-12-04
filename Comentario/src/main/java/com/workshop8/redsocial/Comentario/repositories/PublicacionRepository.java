package com.workshop8.redsocial.Comentario.repositories;

import com.workshop8.redsocial.Comentario.entities.Publicacion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicacionRepository extends CrudRepository<Publicacion, Long> {
}
