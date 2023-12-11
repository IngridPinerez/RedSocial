package com.workshop8.redsocial.Comentario.dtos;

public class CrearDTO {
    private String contenido;

    private Long usuarioId;

    private Long publicacionId;

    public CrearDTO() {
    }

    public CrearDTO(String contenido, Long usuarioId, Long publicacionId) {
        this.contenido = contenido;
        this.usuarioId = usuarioId;
        this.publicacionId = publicacionId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getPublicacionId() {
        return publicacionId;
    }

    public void setPublicacionId(Long publicacionId) {
        this.publicacionId = publicacionId;
    }
}
