package com.makaia.back4.JpaMySql.services;

import com.makaia.back4.JpaMySql.dtos.CrearPublicacionDTO;
import com.makaia.back4.JpaMySql.dtos.CrearUsuarioDTO;
import com.makaia.back4.JpaMySql.dtos.ResponseError;
import com.makaia.back4.JpaMySql.entities.Publicacion;
import com.makaia.back4.JpaMySql.entities.Usuario;
import com.makaia.back4.JpaMySql.exceptions.RedSocialApiException;
import com.makaia.back4.JpaMySql.publisher.Publisher;
import com.makaia.back4.JpaMySql.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class UsuarioService {

    private UsuarioRepository repository;
    private Publisher publisher;

    @Autowired
    public UsuarioService(UsuarioRepository repository, Publisher publisher) {
        this.repository = repository;
        this.publisher = publisher;
    }

    public Usuario crear(CrearUsuarioDTO dto) {
        Usuario exists = this.repository.findByNombre(dto.getNombre());
        if (exists != null) {
            throw new RedSocialApiException("El usuario ya existe", HttpStatusCode.valueOf(400));
        }
        Usuario nuevoUsuario = new Usuario(dto.getNombre(), dto.getApellido(), dto.getDireccion(), dto.getEdad());
        nuevoUsuario = this.repository.save(nuevoUsuario);

        System.out.println(nuevoUsuario);

        crearPublicacionPorDefecto(nuevoUsuario.getId());

        return nuevoUsuario;
    }

    private void crearPublicacionPorDefecto(Long userId) {
        this.publisher.send(userId);
    }

    public List<Usuario> listar() {
        List<Usuario> lista = StreamSupport.stream(this.repository.findAll().spliterator(), false).toList();
        if (lista.isEmpty()){
            throw new RedSocialApiException("Aun no hay usuarios creados",HttpStatusCode.valueOf(500));
        }
        return lista;

    }

    public ResponseEntity<?> getUsuarioById(Long id) {
        Optional<Usuario> optUsuario = this.repository.findById(id);
        if (!optUsuario.isPresent()) {
            return ResponseEntity.status(HttpStatusCode.valueOf(400)).body("El usuario con id " + id + " no existe");
        }
        return ResponseEntity.ok(optUsuario);
    }


}
