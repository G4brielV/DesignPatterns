package com.design_patterns.DesignPatterns.service.Transacao.strategy;

import com.design_patterns.DesignPatterns.service.Transacao.DtoTransacao;


public interface TransacaoStrategy {

    void enviarTransacao(DtoTransacao dtoTransacao);
}
