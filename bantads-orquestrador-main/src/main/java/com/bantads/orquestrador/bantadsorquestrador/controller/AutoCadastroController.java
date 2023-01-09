package com.bantads.orquestrador.bantadsorquestrador.controller;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bantads.orquestrador.bantadsorquestrador.DTOs.ClienteDTO;
import com.bantads.orquestrador.bantadsorquestrador.mapper.ClienteMapper;
import com.bantads.orquestrador.bantadsorquestrador.mapper.UsuarioMapper;
import com.bantads.orquestrador.bantadsorquestrador.model.autenticacao.TipoUsuario;
import com.bantads.orquestrador.bantadsorquestrador.model.autenticacao.Usuario;
import com.bantads.orquestrador.bantadsorquestrador.model.cliente.Cliente;
import com.bantads.orquestrador.bantadsorquestrador.services.Autenticacao.SenderAutenticacao;
import com.bantads.orquestrador.bantadsorquestrador.services.Cliente.SenderCliente;
import com.bantads.orquestrador.bantadsorquestrador.validator.AutocadastroValidator;

@CrossOrigin
@RestController
@RequestMapping("/clientes")
public class AutoCadastroController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private SenderCliente senderCliente;

    @Autowired
    private SenderAutenticacao senderAutenticacao;

    @PostMapping
    ResponseEntity<Object> cadastro(@RequestBody ClienteDTO clienteDTO) {
        try {
            if (AutocadastroValidator.validate(clienteDTO)) {
                UUID saga = UUID.randomUUID();

                Usuario usuario = UsuarioMapper.map(clienteDTO.getUsuario(), saga, mapper);
                usuario.setTipoUsuario(TipoUsuario.Cliente);
                Cliente cliente = ClienteMapper.map(clienteDTO, saga, usuario.getId(), mapper);

                senderCliente.send(cliente);
                senderAutenticacao.send(usuario);

                return new ResponseEntity<Object>(HttpStatus.CREATED);
            } else {
                return ResponseEntity.badRequest().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
