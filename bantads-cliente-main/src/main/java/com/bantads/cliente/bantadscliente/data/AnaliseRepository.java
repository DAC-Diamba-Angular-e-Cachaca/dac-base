package com.bantads.cliente.bantadscliente.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bantads.cliente.bantadscliente.model.Analise;

public interface AnaliseRepository extends JpaRepository<Analise, UUID> {

    @Query("from Analise where aprovado = false and idexternogerente = :idexternogerente and motivo = '' order by datahora")
    public List<Analise> getAnalisesPendentes(@Param("idexternogerente") UUID idexternogerente);

}