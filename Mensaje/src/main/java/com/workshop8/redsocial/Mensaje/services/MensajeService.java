package com.workshop8.redsocial.Mensaje.services;

import com.workshop8.redsocial.Mensaje.dtos.CrearMensajeDTO;
import com.workshop8.redsocial.Mensaje.entities.Mensaje;
import com.workshop8.redsocial.Mensaje.entities.Usuario;
import com.workshop8.redsocial.Mensaje.exceptions.RedSocialApiException;
//import com.workshop8.redsocial.Mensaje.publisher.Publisher;
import com.workshop8.redsocial.Mensaje.repositories.MensajeRepository;
import com.workshop8.redsocial.Mensaje.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class MensajeService {
    MensajeRepository repository;
    UsuarioRepository usuarioRepository;
    //Publisher publisher;

    @Autowired
    public MensajeService(MensajeRepository repository,UsuarioRepository usuarioRepository /*Publisher publisher*/){
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
        //this.publisher = publisher;

    }

    public Mensaje enviar(CrearMensajeDTO dto){
        Usuario emisor = this.usuarioRepository
                .findById(dto.getEmisor())
                .orElseThrow(
                        () -> new RedSocialApiException("El emisor no existe por ende no enviar mensajes"));
        Usuario receptor = this.usuarioRepository
                .findById(dto.getReceptor())
                .orElseThrow(
                        () -> new RedSocialApiException("El receptor no existe por ende no enviar mensajes"));
        if (dto.getContenido().isEmpty()){
                    throw new RedSocialApiException("El contenido del mensaje no puede estar vacio");
        }
        Mensaje nuevoMensaje = new Mensaje(dto.getContenido(),emisor,receptor);
        return this.repository.save(nuevoMensaje);
    }
    public List<Mensaje> listar(){
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }
}
