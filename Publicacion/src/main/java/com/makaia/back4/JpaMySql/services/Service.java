package com.makaia.back4.JpaMySql.services;

import com.makaia.back4.JpaMySql.dtos.CrearDTO;
import com.makaia.back4.JpaMySql.entities.Publicacion;
import com.makaia.back4.JpaMySql.entities.Usuario;
import com.makaia.back4.JpaMySql.exceptions.RedSocialApiException;
import com.makaia.back4.JpaMySql.publisher.Publisher;
import com.makaia.back4.JpaMySql.repositories.PublicacionRepository;
import com.makaia.back4.JpaMySql.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class Service {
    PublicacionRepository repository;
    UsuarioRepository usuarioRepository;
    Publisher publisher;

    @Autowired
    public Service(PublicacionRepository repository, UsuarioRepository usuarioRepository, Publisher publisher) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        this.publisher = publisher;
    }

    public Publicacion crear(CrearDTO dto) {
        Usuario usuario = this.usuarioRepository
                .findById(dto.getUsuarioId())
                .orElseThrow(
                        () -> new RedSocialApiException("El usuario no existe y no puede crear publicaciones"));
        Publicacion nuevaPublicacion = new Publicacion(dto.getTitulo(), dto.getContenido(), usuario);

        nuevaPublicacion = this.repository.save(nuevaPublicacion);

        crearComentarioPorDefecto(dto.getUsuarioId(), nuevaPublicacion.getId());

        return nuevaPublicacion;
    }

    private void crearComentarioPorDefecto(Long userId, Long postId) {
        this.publisher.send(userId+","+postId);
    }

    public List<Publicacion> listar() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }


}
