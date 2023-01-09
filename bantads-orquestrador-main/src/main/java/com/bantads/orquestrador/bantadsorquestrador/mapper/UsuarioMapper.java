package com.bantads.orquestrador.bantadsorquestrador.mapper;

import java.util.UUID;

import org.modelmapper.ModelMapper;

import com.bantads.orquestrador.bantadsorquestrador.DTOs.UsuarioDTO;
import com.bantads.orquestrador.bantadsorquestrador.model.autenticacao.Usuario;

public final class UsuarioMapper {
    public static Usuario map(UsuarioDTO usuarioDTO, UUID saga, ModelMapper mapper) {
        Usuario usuario = mapper.map(usuarioDTO, Usuario.class);
        usuario.setId(UUID.randomUUID());
        usuario.setSaga(saga);
        return usuario;
    }
}
