package com.workshop8.redsocial.Mensaje.dtos;

import com.workshop8.redsocial.Mensaje.entities.Usuario;

public class CrearMensajeDTO {
    private long id;
    private String contenido;
    private Usuario emisor;
    private Usuario receptor;


    public CrearMensajeDTO(long id, String contenido, Usuario emisor, Usuario receptor) {
        this.id = id;
        this.contenido = contenido;
        this.emisor = emisor;
        this.receptor = receptor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }
}
