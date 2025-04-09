package com.design_patterns.DesignPatterns.model.Transacao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByRemetenteId(Long remetenteId);
    List<Transacao> findByDestinatarioId(Long destinatarioId);

    @Query("SELECT t FROM Transacao t WHERE t.remetente.id = :id OR t.destinatario.id = :id")
    List<Transacao> findTodasPorCliente(@Param("id") Long clienteId);
}
