package com.workshop8.redsocial.Mensaje.entities;

import jakarta.persistence.*;

@Entity
@Table
public class Mensaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String contenido;

    @ManyToOne(optional = false)
    Usuario emisor;

    @ManyToOne(optional = false)
    Usuario receptor;

    public Mensaje(long id, String contenido, Usuario emisor, Usuario receptor) {
        this.id = id;
        this.contenido = contenido;
        this.emisor = emisor;
        this.receptor = receptor;
    }
}
