package com.workshop8.redsocial.Amistad.repositories;


import com.workshop8.redsocial.Amistad.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
