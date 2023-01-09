package com.bantads.conta.bantadsconta.data.CUD;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bantads.conta.bantadsconta.model.CUD.MovimentacaoC;

public interface MovimentacaoCRepository extends JpaRepository<MovimentacaoC, UUID>{

}
