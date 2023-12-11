package com.workshop8.redsocial.Amistad.dto;

import java.util.Date;

public class CrearAmistadDTO {

    private String isAceptado;
    private Date fecha;
    private Long solicitanteId;
    private Long solicitadoId;

    public CrearAmistadDTO() {
    }

    public CrearAmistadDTO(String isAceptado, Date fecha, Long solicitanteId, Long solicitadoId) {
        this.isAceptado = isAceptado;
        this.fecha = fecha;
        this.solicitanteId = solicitanteId;
        this.solicitadoId = solicitadoId;
    }

    public String getIsAceptado() {
        return isAceptado;
    }

    public void setIsAceptado(String isAceptado) {
        this.isAceptado = isAceptado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getSolicitanteId() {
        return solicitanteId;
    }

    public void setSolicitanteId(Long solicitanteId) {
        this.solicitanteId = solicitanteId;
    }

    public Long getSolicitadoId() {
        return solicitadoId;
    }

    public void setSolicitadoId(Long solicitadoId) {
        this.solicitadoId = solicitadoId;
    }
}
