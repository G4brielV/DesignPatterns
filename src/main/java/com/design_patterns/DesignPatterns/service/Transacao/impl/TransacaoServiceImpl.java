package com.design_patterns.DesignPatterns.service.Transacao.impl;

import com.design_patterns.DesignPatterns.model.Cliente.ClienteRepository;
import com.design_patterns.DesignPatterns.model.Transacao.Transacao;
import com.design_patterns.DesignPatterns.model.Transacao.TransacaoRepository;
import com.design_patterns.DesignPatterns.service.Transacao.DtoTransacao;
import com.design_patterns.DesignPatterns.service.Transacao.TransacaoService;
import com.design_patterns.DesignPatterns.service.Transacao.strategy.TransacaoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransacaoServiceImpl implements TransacaoService {


    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;
    private final Map<String, TransacaoStrategy> mapStrategy;

    @Autowired
    public TransacaoServiceImpl(ClienteRepository clienteRepository,
                                TransacaoRepository transacaoRepository,
                                Map<String, TransacaoStrategy> mapStrategy) {
        this.clienteRepository = clienteRepository;
        this.transacaoRepository = transacaoRepository;
        this.mapStrategy = mapStrategy;
    }


    @Override
    public List<Transacao> transacaoCliente(Long id){
        return transacaoRepository.findTodasPorCliente(id);
    }

    @Override
    public void realizarTransacao(DtoTransacao dtoTransacao) {
        mapStrategy.get(dtoTransacao.tipo()).enviarTransacao(dtoTransacao);
    }

}
