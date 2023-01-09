package com.bantads.orquestrador.bantadsorquestrador.validator;

import com.bantads.orquestrador.bantadsorquestrador.DTOs.ClienteDTO;
import com.bantads.orquestrador.bantadsorquestrador.DTOs.EnderecoDTO;
import com.bantads.orquestrador.bantadsorquestrador.DTOs.UsuarioDTO;

public final class AutocadastroValidator {
    public static boolean validate(ClienteDTO clienteDTO) {
        if (validateCliente(clienteDTO) &&
                validateEndereco(clienteDTO.getEndereco()) &&
                validateUsuario(clienteDTO.getUsuario())) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean validateCliente(ClienteDTO clienteDTO) {
        if (CommonValidator.validateString(clienteDTO.getNome()) ||
                CommonValidator.validateString(clienteDTO.getCpf()) ||
                clienteDTO.getCpf().length() != 11 ||
                clienteDTO.getSalario().doubleValue() <= 0.0 ||
                clienteDTO.getEndereco() == null ||
                clienteDTO.getUsuario() == null) {
            return false;
        } else {
            return true;
        }

    }

    private static boolean validateEndereco(EnderecoDTO enderecoDTO) {
        if (CommonValidator.validateString(enderecoDTO.getCep()) ||
                CommonValidator.validateString(enderecoDTO.getLogradouro()) ||
                CommonValidator.validateString(enderecoDTO.getBairro()) ||
                CommonValidator.validateString(enderecoDTO.getCidade()) ||
                enderecoDTO.getNumero() <= 0 ||
                enderecoDTO.getEstado() == null) {
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
