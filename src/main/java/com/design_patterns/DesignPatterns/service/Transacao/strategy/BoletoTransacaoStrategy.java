package com.design_patterns.DesignPatterns.service.Transacao.strategy;

import com.design_patterns.DesignPatterns.model.Cliente.Cliente;
import com.design_patterns.DesignPatterns.model.Cliente.ClienteRepository;
import com.design_patterns.DesignPatterns.model.Transacao.Tipo;
import com.design_patterns.DesignPatterns.model.Transacao.Transacao;
import com.design_patterns.DesignPatterns.model.Transacao.TransacaoRepository;
import com.design_patterns.DesignPatterns.controller.dto.DtoTransacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Component("Boleto")
public class BoletoTransacaoStrategy implements TransacaoStrategy{
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TransacaoRepository transacaoRepository;

    @Override
    public void enviarTransacao(DtoTransacao dtoTransacao) {
        Cliente remetente = clienteRepository.findById(dtoTransacao.remetenteId())
                .orElseThrow(() -> new RuntimeException("Remetente não encontrado"));

        Cliente destinatario = clienteRepository.findById(dtoTransacao.destinatarioId())
                .orElseThrow(() -> new RuntimeException("Destinatário não encontrado"));

        BigDecimal taxa = new BigDecimal("0.2");

        // Salva transação
        Transacao transacao = new Transacao();
        transacao.setTipo(Tipo.Boleto);
        transacao.setTaxa(dtoTransacao.valor().multiply(taxa));
        transacao.setValor(dtoTransacao.valor());
        transacao.setDateTime(LocalDateTime.now());
        transacao.setRemetente(remetente);
        transacao.setDestinatario(destinatario);

        transacaoRepository.save(transacao);
    }
}
