package com.workshop8.redsocial.Amistad.dto;

import java.util.Date;

public class CrearAmistadDTO {

    private Date fecha;
    private Long solicitanteId;
    private Long solicitadoId;

    public CrearAmistadDTO() {
    }

    public CrearAmistadDTO(Date fecha, Long solicitanteId, Long solicitadoId) {
        this.fecha = fecha;
        this.solicitanteId = solicitanteId;
        this.solicitadoId = solicitadoId;
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
