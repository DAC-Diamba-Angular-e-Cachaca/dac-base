package com.bantads.cliente.bantadscliente.mapper;

import org.modelmapper.ModelMapper;

import com.bantads.cliente.bantadscliente.DTOs.ClientePutDTO;
import com.bantads.cliente.bantadscliente.model.Cliente;

public final class ClienteMapper {
    public static void map(Cliente cliente, ClientePutDTO clientePutDTO, ModelMapper mapper){
        cliente.setNome(clientePutDTO.getNome());
        cliente.setSalario(clientePutDTO.getSalario());
        cliente.getEndereco().setCep(clientePutDTO.getEndereco().getCep());
        cliente.getEndereco().setLogradouro(clientePutDTO.getEndereco().getLogradouro());
        cliente.getEndereco().setNumero(clientePutDTO.getEndereco().getNumero());
        cliente.getEndereco().setComplemento(clientePutDTO.getEndereco().getComplemento());
        cliente.getEndereco().setBairro(clientePutDTO.getEndereco().getBairro());
        cliente.getEndereco().setCidade(clientePutDTO.getEndereco().getCidade());
        cliente.getEndereco().setEstado(clientePutDTO.getEndereco().getEstado());
    }
}
