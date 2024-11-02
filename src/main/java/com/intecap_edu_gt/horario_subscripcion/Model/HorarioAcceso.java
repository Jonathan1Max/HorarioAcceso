package com.intecap_edu_gt.horario_subscripcion.Model;

import java.time.LocalDateTime;

public class HorarioAcceso {
    private Long id;
    private String clienteId;
    private LocalDateTime inicioAcceso;
    private LocalDateTime finAcceso;
    private boolean activo;

    // Getters
    public Long getId() {
        return id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public LocalDateTime getInicioAcceso() {
        return inicioAcceso;
    }

    public LocalDateTime getFinAcceso() {
        return finAcceso;
    }

    public boolean isActivo() {
        return activo;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public void setInicioAcceso(LocalDateTime inicioAcceso) {
        this.inicioAcceso = inicioAcceso;
    }

    public void setFinAcceso(LocalDateTime finAcceso) {
        this.finAcceso = finAcceso;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}
