package com.design_patterns.DesignPatterns.service.Transacao;

import com.design_patterns.DesignPatterns.model.Cliente.ClienteRepository;
import com.design_patterns.DesignPatterns.model.Transacao.Transacao;
import com.design_patterns.DesignPatterns.model.Transacao.TransacaoRepository;
import com.design_patterns.DesignPatterns.service.Transacao.strategy.TransacaoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TransacaoService {


    private final ClienteRepository clienteRepository;
    private final TransacaoRepository transacaoRepository;
    private final Map<String, TransacaoStrategy> mapStrategy;

    @Autowired
    public TransacaoService(ClienteRepository clienteRepository,
                            TransacaoRepository transacaoRepository,
                            Map<String, TransacaoStrategy> mapStrategy) {
        this.clienteRepository = clienteRepository;
        this.transacaoRepository = transacaoRepository;
        this.mapStrategy = mapStrategy;
    }

    public List<Transacao> transacaoCliente(Long id){
        return transacaoRepository.findTodasPorCliente(id);
    }

    public void realizarTransacao(DtoTransacao dtoTransacao) {
        mapStrategy.get(dtoTransacao.tipo()).enviarTransacao(dtoTransacao);
    }
}
