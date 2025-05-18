package com.design_patterns.DesignPatterns.controller;

import com.design_patterns.DesignPatterns.model.Transacao.Transacao;
import com.design_patterns.DesignPatterns.service.Transacao.DtoTransacao;
import com.design_patterns.DesignPatterns.service.Transacao.impl.TransacaoServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {

    @Autowired
    private TransacaoServiceImpl transacaoService;

    @Operation(
            summary = "Todos as transacoes de um cliente pelo seu ID"
    )
    @GetMapping("/{id}")
    public List<Transacao> buscarTordasTransacoesDoCliente(@PathVariable Long id){
        return transacaoService.transacaoCliente(id);
    }


    @Operation(
            summary = "Fazer nova transacao"
    )
    @PostMapping
    public void novaTransacao(@RequestBody DtoTransacao dtoTransacao){
        transacaoService.realizarTransacao(dtoTransacao);
    }
}
