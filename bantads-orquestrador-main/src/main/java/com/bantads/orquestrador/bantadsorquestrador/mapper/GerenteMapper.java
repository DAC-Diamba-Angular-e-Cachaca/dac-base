package com.bantads.orquestrador.bantadsorquestrador.mapper;

import java.util.UUID;

import org.modelmapper.ModelMapper;

import com.bantads.orquestrador.bantadsorquestrador.DTOs.GerenteDTO;
import com.bantads.orquestrador.bantadsorquestrador.model.gerente.Gerente;

public final class GerenteMapper {
    public static Gerente map(GerenteDTO gerenteDTO, UUID saga, UUID usuarioId, ModelMapper mapper) {
        Gerente gerente = mapper.map(gerenteDTO, Gerente.class);
        gerente.setId(UUID.randomUUID());
        gerente.setSaga(saga);
        gerente.setIdExternoUsuario(usuarioId);
        return gerente;
    }
}
