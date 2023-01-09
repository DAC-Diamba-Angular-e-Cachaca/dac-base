package com.bantads.cliente.bantadscliente.data;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bantads.cliente.bantadscliente.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, UUID> {
    public Optional<Cliente> findByIdExternoUsuario(UUID idExternoUsuario);
    public Optional<Cliente> findByCpf(String cpf);
    @Transactional
    public Long deleteBySaga(UUID saga);
}
