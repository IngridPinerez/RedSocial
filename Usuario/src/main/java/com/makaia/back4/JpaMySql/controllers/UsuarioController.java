package com.makaia.back4.JpaMySql.controllers;

import com.makaia.back4.JpaMySql.services.UsuarioService;
import com.makaia.back4.JpaMySql.dtos.CrearUsuarioDTO;
import com.makaia.back4.JpaMySql.entities.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/usuario")
public class UsuarioController {
    private UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @PostMapping()
    public Usuario crearUsuario(@RequestBody CrearUsuarioDTO dto) {
        return this.service.crear(dto);
    }

    @GetMapping()
    public List<Usuario> listarUsuarios(){
        return  this.service.listar();
    }

    @GetMapping("/usuario/{id}")
<<<<<<< Updated upstream
    public Usuario getUsuarioById(@PathVariable("id") Long id){
=======
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") Long id){
>>>>>>> Stashed changes
        return service.getUsuarioById(id);
    }
}
