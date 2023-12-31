package com.makaia.back4.JpaMySql.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "mensaje")
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

    public Long getId() {
        return id;
    }

    public String getContenido() {
        return contenido;
    }

}
