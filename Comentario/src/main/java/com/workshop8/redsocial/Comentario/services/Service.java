package com.workshop8.redsocial.Comentario.services;

import com.workshop8.redsocial.Comentario.dtos.CrearDTO;
import com.workshop8.redsocial.Comentario.entities.Comentario;
import com.workshop8.redsocial.Comentario.entities.Publicacion;
import com.workshop8.redsocial.Comentario.entities.Usuario;
import com.workshop8.redsocial.Comentario.exceptions.RedSocialApiException;
import com.workshop8.redsocial.Comentario.repositories.PublicacionRepository;
import com.workshop8.redsocial.Comentario.repositories.UsuarioRepository;
import com.workshop8.redsocial.Comentario.repositories.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class Service {
    ComentarioRepository repository;
    UsuarioRepository usuarioRepository;
    PublicacionRepository publicacionRepository;

    @Autowired
    public Service(ComentarioRepository repository, UsuarioRepository usuarioRepository, PublicacionRepository publicacionRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.publicacionRepository = publicacionRepository;
    }

    public Comentario crear(CrearDTO dto) {
        Usuario usuario = this.usuarioRepository
                .findById(dto.getUsuarioId())
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede crear comentarios"));
        Publicacion publicacion = this.publicacionRepository
                .findById(dto.getPublicacionId())
                .orElseThrow(
                        () -> new RedSocialApiException("La publicacion no existe y no puede crear comentarios"));
        Comentario nuevoUsuario = new Comentario(dto.getContenido(), usuario, publicacion);
        return this.repository.save(nuevoUsuario);
    }

    public List<Comentario> listar() {
        List<Comentario> result = StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();

        return result;
    }
}
