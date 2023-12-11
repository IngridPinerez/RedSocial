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
import java.util.Optional;
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
                        () -> new RedSocialApiException("El usuario no existe"));
        Publicacion publicacion = this.publicacionRepository
                .findById(dto.getPublicacionId())
                .orElseThrow(
                        () -> new RedSocialApiException("La publicacion no existe"));
        Comentario nuevoComentario = new Comentario(dto.getContenido(), usuario, publicacion);
        return this.repository.save(nuevoComentario);
    }

    public List<Comentario> listar() {
        List<Comentario> result = StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();

        return result;
    }

    public void borrar(Long comentarioId) {
        this.repository.deleteById(comentarioId);
    }

    public Optional<Comentario> buscar(Long comentarioId) {
        return this.repository.findById(comentarioId);
    }

    public Comentario actualizar(Long comentarioId, CrearDTO dto) {
        Comentario comentarioExistente = this.repository.findById(comentarioId)
                .orElseThrow(() -> new RedSocialApiException("El comentario no existe"));

        Usuario usuario = this.usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RedSocialApiException("El usuario no existe"));

        Publicacion publicacion = this.publicacionRepository.findById(dto.getPublicacionId())
                .orElseThrow(() -> new RedSocialApiException("La publicacion no existe"));

        comentarioExistente.setContenido(dto.getContenido());
        comentarioExistente.setUsuario(usuario);
        comentarioExistente.setPublicacion(publicacion);

        return this.repository.save(comentarioExistente);
    }
}
