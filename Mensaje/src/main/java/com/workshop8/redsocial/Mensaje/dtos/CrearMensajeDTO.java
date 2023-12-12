package com.workshop8.redsocial.Mensaje.dtos;

import com.workshop8.redsocial.Mensaje.entities.Usuario;

public class CrearMensajeDTO {

    private String contenido;
    private Long emisor;
    private Long receptor;


    public CrearMensajeDTO(String contenido, Long emisor, Long receptor) {
        this.contenido = contenido;
        this.emisor = emisor;
        this.receptor = receptor;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getEmisor() {
        return emisor;
    }

    public void setEmisor(Long emisor) {
        this.emisor = emisor;
    }

    public Long getReceptor() {
        return receptor;
    }

    public void setReceptor(Long receptor) {
        this.receptor = receptor;
    }
}
