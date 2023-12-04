package com.workshop8.redsocial.Comentario.repositories;

import com.workshop8.redsocial.Comentario.entities.Amistad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmistadRepository extends CrudRepository<Amistad, Long> {
}
