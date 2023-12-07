package com.workshop8.redsocial.Amistad.service;

import com.workshop8.redsocial.Amistad.dto.CrearAmistadDTO;
import com.workshop8.redsocial.Amistad.entities.Amistad;
import com.workshop8.redsocial.Amistad.entities.Usuario;
import com.workshop8.redsocial.Amistad.exceptions.AmistadApiException;
import com.workshop8.redsocial.Amistad.feignClient.IUsuarioFeignClient;
import com.workshop8.redsocial.Amistad.repositories.AmistadRepository;
import com.workshop8.redsocial.Amistad.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
            IUsuarioFeignClient iUsuarioFeignClient;
    AmistadRepository repository;
    UsuarioRepository usuarioRepository;

    @Autowired
    public Service(AmistadRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public Amistad crear(CrearAmistadDTO dto) {
        Usuario usuarioSolicitante = this.usuarioRepository
                .findById(dto.getSolicitanteId())
                .orElseThrow(() -> new AmistadApiException("El usuario solicitante no existe", HttpStatusCode.valueOf(500)));
        Usuario usuarioSolicitado = this.usuarioRepository
                .findById(dto.getSolicitadoId())
                .orElseThrow(() -> new AmistadApiException("El usuario solicitado no existe", HttpStatusCode.valueOf(500)));

        if (dto.getSolicitanteId() == dto.getSolicitadoId()){
            throw new AmistadApiException("El Id del solicitante no puede ser el mismo que el Id del solicitado",HttpStatusCode.valueOf(400));
        } else{

        }
        Amistad nuevaAmistad = new Amistad(dto.getFecha(),usuarioSolicitante,usuarioSolicitado);
        return this.repository.save(nuevaAmistad);
    }

    public List<Amistad> listar() {
        return StreamSupport
                .stream(this.repository.findAll().spliterator(), false)
                .toList();
    }

    public Amistad getAmistadById(Long id) {
        Optional<Amistad> optAmistad = this.repository.findById(id);
        if (!optAmistad.isPresent()) {
            throw  new AmistadApiException("Amistad no existe");
        }
        return optAmistad.get();
    }

    public Amistad responderAmistad(Long id,String respuesta){

        Optional<Amistad> optAmistad = this.repository.findById(id);
        if (!optAmistad.isPresent()){
            throw  new AmistadApiException("Amistad no existe");
        }else if(optAmistad.get().getIsAceptado()=="Pendiente"){
            optAmistad.get().setIsAceptado(respuesta);
        }
        else {
            throw new AmistadApiException("La solicitud de amistad ya fue respondida");
        }

        return optAmistad.get();
    }


}
