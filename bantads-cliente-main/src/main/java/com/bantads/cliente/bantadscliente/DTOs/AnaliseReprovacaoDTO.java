package com.bantads.cliente.bantadscliente.DTOs;

public class AnaliseReprovacaoDTO {
    private String motivo;

    public AnaliseReprovacaoDTO() {
    }

    public AnaliseReprovacaoDTO(String motivo) {
        this.motivo = motivo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

}
