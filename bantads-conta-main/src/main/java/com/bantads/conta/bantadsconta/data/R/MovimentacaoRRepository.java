package com.bantads.conta.bantadsconta.data.R;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bantads.conta.bantadsconta.model.R.MovimentacaoR;


public interface MovimentacaoRRepository extends JpaRepository<MovimentacaoR, UUID> {

	List<MovimentacaoR> findByDataHoraBetween(Date startDate, Date endDate);
	
	@Query(value = "select m.id, m.valor, m.datahora, m.tipomovimentacao, m.origem, m.destino, m.saga from movimentacao m where (origem = :idExternoCliente or destino = :idExternoCliente) and datahora >= :dataInicio and datahora <= :dataFim ", nativeQuery = true)
	List<MovimentacaoR> obtemMovimentacoesCliente(@Param("idExternoCliente") UUID idExternoCliente, @Param("dataInicio") Date dataInicio, @Param("dataFim") Date dataFim);
}
