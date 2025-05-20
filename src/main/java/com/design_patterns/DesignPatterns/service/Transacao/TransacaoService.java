package com.design_patterns.DesignPatterns.service.Transacao;

import com.design_patterns.DesignPatterns.controller.dto.DtoTransacao;
import com.design_patterns.DesignPatterns.model.Transacao.Transacao;
import java.util.List;

public interface TransacaoService {
    List<Transacao> transacaoCliente(Long id);
    void realizarTransacao(DtoTransacao dtoTransacao);
}