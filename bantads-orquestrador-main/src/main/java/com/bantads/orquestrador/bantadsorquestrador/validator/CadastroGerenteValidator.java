package com.bantads.orquestrador.bantadsorquestrador.validator;

import com.bantads.orquestrador.bantadsorquestrador.DTOs.GerenteDTO;
import com.bantads.orquestrador.bantadsorquestrador.DTOs.UsuarioDTO;

public final class CadastroGerenteValidator {
    public static boolean validate(GerenteDTO gerenteDTO) {
        if (validateGerente(gerenteDTO) &&
                validateUsuario(gerenteDTO.getUsuario())) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean validateGerente(GerenteDTO gerenteDTO) {
        if (CommonValidator.validateString(gerenteDTO.getNome()) ||
                CommonValidator.validateString(gerenteDTO.getCpf()) ||
                gerenteDTO.getCpf().length() != 11 ||
                gerenteDTO.getUsuario() == null) {
            return false;
        } else {
            return true;
        }
    }

    private static boolean validateUsuario(UsuarioDTO usuarioDTO) {
        if (CommonValidator.validateString(usuarioDTO.getEmail())) {
            return false;
        } else {
            return true;
        }
    }
}
