package com.workshop8.redsocial.Amistad.entities;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table
public class Amistad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column
    private String isAceptado = "Pendiente";

    @Column(nullable = false)
    private Date fecha;

    @ManyToOne(optional = false)
    Usuario solicitante;

    @ManyToOne(optional = false)
    Usuario solicitado;

    public Amistad() {
    }

    public Amistad(Date fecha, Usuario solicitante, Usuario solicitado) {
        this.fecha = fecha;
        this.solicitante = solicitante;
        this.solicitado = solicitado;
    }

    public Long getId() {
        return id;
    }

    public String getIsAceptado() {
        return isAceptado;
    }

    public Date getFecha() {
        return fecha;
    }

    public Usuario getSolicitante() {
        return solicitante;
    }

    public Usuario getSolicitado() {
        return solicitado;
    }

    public void setIsAceptado(String isAceptado) {
        this.isAceptado = isAceptado;
    }
}
