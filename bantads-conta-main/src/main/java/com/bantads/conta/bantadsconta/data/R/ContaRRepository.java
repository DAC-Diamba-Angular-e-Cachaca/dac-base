package com.bantads.conta.bantadsconta.data.R;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bantads.conta.bantadsconta.model.R.ContaR;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

public interface ContaRRepository extends JpaRepository<ContaR, UUID> {
	ContaR findByIdExternoCliente(UUID idCliente);
	Optional<ContaR> findById(UUID id);
	Optional<List<ContaR>> findByIdExternoGerente(UUID idExternoGerente);
	
	@Transactional
	public Long deleteBySaga(UUID id);
}
