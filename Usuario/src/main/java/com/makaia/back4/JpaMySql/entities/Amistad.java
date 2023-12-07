package com.makaia.back4.JpaMySql.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Amistad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String isAceptado ="Pendiente";

    @Column(nullable = true)
    private Date fecha;

    @ManyToOne(optional = false)
    Usuario solicitante;

    @ManyToOne(optional = false)
    Usuario solicitado;

    public Long getId() {
        return id;
    }

    public String getIsAceptado() {
        return isAceptado;
    }

    public Date getFecha() {
        return fecha;
    }


}
