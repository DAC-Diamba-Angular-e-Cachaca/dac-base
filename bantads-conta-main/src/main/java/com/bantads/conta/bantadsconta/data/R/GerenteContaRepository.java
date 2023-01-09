package com.bantads.conta.bantadsconta.data.R;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.bantads.conta.bantadsconta.model.R.GerenteConta;

public interface GerenteContaRepository extends JpaRepository<GerenteConta, UUID> {
	GerenteConta findByIdExternoGerente(UUID idExternoGerente);
	GerenteConta findBySaga(UUID saga);

	@Query(value = "select coalesce(sum(saldo), 0) from Conta where saldo > 0 and idexternogerente = :idExternoGerente", nativeQuery = true)
	double calculaSaldoPositivo(@Param("idExternoGerente") UUID idExternoGerente);	
	    @Transactional
    public Long deleteBySaga(UUID saga);

	@Query(value = "select coalesce(sum(saldo), 0) from Conta where saldo < 0 and idexternogerente = :idExternoGerente", nativeQuery = true)
	double calculaSaldoNegativo(@Param("idExternoGerente") UUID idExternoGerente);	

	@Query(value = "from GerenteConta where ativo = true order by quantidadeContas asc")
    public List<GerenteConta> getGerenteContaMenosContas();
}
