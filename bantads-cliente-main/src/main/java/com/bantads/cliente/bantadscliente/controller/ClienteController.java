package com.bantads.cliente.bantadscliente.controller;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bantads.cliente.bantadscliente.DTOs.ClientePutDTO;
import com.bantads.cliente.bantadscliente.DTOs.ClienteResponseDTO;
import com.bantads.cliente.bantadscliente.data.ClienteRepository;
import com.bantads.cliente.bantadscliente.mapper.ClienteMapper;
import com.bantads.cliente.bantadscliente.model.Cliente;
import com.bantads.cliente.bantadscliente.validator.ClienteValidator;

@CrossOrigin
@RestController
@RequestMapping("clientes")
public class ClienteController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> update(@PathVariable("id") UUID id, @RequestBody ClientePutDTO clientePutDTO) {
        try {
            if (ClienteValidator.validate(clientePutDTO))
                return ResponseEntity.badRequest().build();

            Optional<Cliente> clienteOp = clienteRepository.findById(id);
            if (!clienteOp.isPresent())
                return ResponseEntity.notFound().build();

            Cliente cliente = clienteOp.get();
            ClienteMapper.map(cliente, clientePutDTO, mapper);
            clienteRepository.save(cliente);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> getCliente(@PathVariable UUID id) {
        try {
            Optional<Cliente> clienteOp = clienteRepository.findById(id);

            if (!clienteOp.isPresent())
                return ResponseEntity.notFound().build();

            Cliente cliente = clienteOp.get();
            ClienteResponseDTO ClienteResponseDTO = mapper.map(cliente, ClienteResponseDTO.class);
            return ResponseEntity.ok(ClienteResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/por-cpf/{cpf}")
    public ResponseEntity<ClienteResponseDTO> getClientePorIdUsuario(@PathVariable String cpf) {
        try {
            if (ClienteValidator.validateCpf(cpf))
                return ResponseEntity.badRequest().build();

            Optional<Cliente> clienteOp = clienteRepository.findByCpf(cpf);
            if (!clienteOp.isPresent())
                return ResponseEntity.notFound().build();

            Cliente cliente = clienteOp.get();
            ClienteResponseDTO ClienteResponseDTO = mapper.map(cliente, ClienteResponseDTO.class);
            return ResponseEntity.ok(ClienteResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/por-usuario/{idExternoUsuario}")
    public ResponseEntity<ClienteResponseDTO> getClientePorIdUsuario(@PathVariable UUID idExternoUsuario) {
        try {
            Optional<Cliente> clienteOp = clienteRepository.findByIdExternoUsuario(idExternoUsuario);

            if (!clienteOp.isPresent())
                return ResponseEntity.notFound().build();

            Cliente cliente = clienteOp.get();
            ClienteResponseDTO ClienteResponseDTO = mapper.map(cliente, ClienteResponseDTO.class);
            return ResponseEntity.ok(ClienteResponseDTO);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/health")
    public String health() {
        return "ʕ·͡ᴥ·ʔ";
    }
}
