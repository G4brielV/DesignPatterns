package com.design_patterns.DesignPatterns.controller;

import com.design_patterns.DesignPatterns.model.Cliente.Cliente;
import com.design_patterns.DesignPatterns.service.Cliente.impl.ClienteServiceImpl;
import com.design_patterns.DesignPatterns.controller.dto.DtoCadastrarCliente;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteServiceImpl clienteService;

    @Operation(
            summary = "Todos os Clientes e suas transações"
    )
    @GetMapping
    public List<Cliente> todosClientes(){
        return clienteService.listarClientes();
    }

    @Operation(
            summary = "Todos os dados de um Cliente e suas Transações"
    )
    @GetMapping("/{id}")
    public Optional<Cliente> detalheCliente(@PathVariable Long id){
        return clienteService.detalharCliente(id);
    }

    @Operation(
            summary = "Adicionar um Cliente"
    )
    @PostMapping
    public void adicionarCliente(@RequestBody DtoCadastrarCliente dtoCadastrarCliente){
        clienteService.cadastrarCliente(dtoCadastrarCliente);
    }
}
