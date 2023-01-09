package com.bantads.cliente.bantadscliente.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.bantads.cliente.bantadscliente.DTOs.AnalisePendenteDTO;
import com.bantads.cliente.bantadscliente.model.Analise;

public final class AnaliseMapper {
    public static Analise novaAnalise(UUID saga){
        Analise analise = new Analise();
        analise.setId(UUID.randomUUID());
        analise.setSaga(saga);
        analise.setDataHora(LocalDateTime.now());
        analise.setAprovacao(false);
        analise.setMotivo("");
        return analise;        
    }

    public static List<AnalisePendenteDTO> toResponseDTO(List<Analise> analises) {
        List<AnalisePendenteDTO> response = new ArrayList<AnalisePendenteDTO>();
        for(Analise analise : analises){
            AnalisePendenteDTO analisePendente = new AnalisePendenteDTO(
                analise.getId(),
                analise.getCliente().getNome(),
                analise.getCliente().getCpf(),
                analise.getCliente().getSalario()
            );
            response.add(analisePendente);
        }
        return response;
    }
}
