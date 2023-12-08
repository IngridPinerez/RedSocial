package com.workshop8.redsocial.Comentario.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String contenido;

    @ManyToOne(optional = false)
    Usuario usuario;

    @ManyToOne(optional = false)
    Publicacion publicacion;

    public Comentario() {
    }

    public Comentario(String contenido, Usuario usuario, Publicacion publicacion) {
        this.contenido = contenido;
        this.usuario = usuario;
        this.publicacion = publicacion;
    }

    public String getContenido() {
        return contenido;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Publicacion getPublicacion() {
        return publicacion;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setPublicacion(Publicacion publicacion) {
        this.publicacion = publicacion;
    }
}
