package com.bantads.cliente.bantadscliente.validator;

import com.bantads.cliente.bantadscliente.DTOs.ClientePutDTO;
import com.bantads.cliente.bantadscliente.DTOs.EnderecoPutDTO;

public final class ClienteValidator {
    public static boolean validate(ClientePutDTO clientePutDTO) {
        if (
            validate(clientePutDTO.getEndereco()) ||
            CommonValidator.validateString(clientePutDTO.getNome()) ||
            clientePutDTO.getSalario().doubleValue() <= 0.0
        ) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validate(EnderecoPutDTO enderecoPutDTO) {
        if (
            CommonValidator.validateString(enderecoPutDTO.getBairro()) ||
            CommonValidator.validateString(enderecoPutDTO.getCep()) ||
            CommonValidator.validateString(enderecoPutDTO.getCidade()) ||
            CommonValidator.validateString(enderecoPutDTO.getLogradouro())
        ) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean validateCpf(String cpf) {
        if (
            cpf.length() != 11
        ) {
            return true;
        } else {
            return false;
        }
    }
}
