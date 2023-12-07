package com.workshop8.redsocial.Amistad.repositories;

import com.workshop8.redsocial.Amistad.entities.Amistad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AmistadRepository extends CrudRepository<Amistad, Long> {
}
