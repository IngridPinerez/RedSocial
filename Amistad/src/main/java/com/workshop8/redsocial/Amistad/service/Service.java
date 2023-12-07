package com.workshop8.redsocial.Amistad.service;

import com.workshop8.redsocial.Amistad.dto.CrearDTO;
import com.workshop8.redsocial.Amistad.entities.Amistad;
import com.workshop8.redsocial.Amistad.entities.Usuario;
import com.workshop8.redsocial.Amistad.exceptions.AmistadApiException;
import com.workshop8.redsocial.Amistad.repositories.AmistadRepository;
import com.workshop8.redsocial.Amistad.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@org.springframework.stereotype.Service
public class Service {
    AmistadRepository repository;
    UsuarioRepository usuarioRepository;

    @Autowired
    public Service(AmistadRepository repository, UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public Amistad crear(CrearDTO dto) {
        Usuario usuarioSolicitante = this.usuarioRepository
                .findById(dto.getSolicitanteId())
                .orElseThrow(() -> new AmistadApiException("El usuario solicitante no existe"));
        Usuario usuarioSolicitado = this.usuarioRepository
                .findById(dto.getSolicitadoId())
                .orElseThrow(() -> new AmistadApiException("El usuario solicitado no existe"));

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
            throw  new AmistadApiException("Usuario no existe");
        }
        return optAmistad.get();
    }


}
