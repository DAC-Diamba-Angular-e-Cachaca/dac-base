package com.bantads.orquestrador.bantadsorquestrador.mapper;

import java.util.UUID;

import org.modelmapper.ModelMapper;

import com.bantads.orquestrador.bantadsorquestrador.DTOs.ClienteDTO;
import com.bantads.orquestrador.bantadsorquestrador.model.cliente.Cliente;

public final class ClienteMapper {
    public static Cliente map(ClienteDTO clienteDTO, UUID saga, UUID usuarioId, ModelMapper mapper) {
        Cliente cliente = mapper.map(clienteDTO, Cliente.class);
        cliente.setId(UUID.randomUUID());
        cliente.setSaga(saga);
        cliente.setIdExternoUsuario(usuarioId);
        return cliente;
    }
}
