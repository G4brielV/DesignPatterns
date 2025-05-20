package com.design_patterns.DesignPatterns.service.Cliente;

import com.design_patterns.DesignPatterns.controller.dto.DtoCadastrarCliente;
import com.design_patterns.DesignPatterns.model.Cliente.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listarClientes();
    Optional<Cliente> detalharCliente(Long id);
    void cadastrarCliente(DtoCadastrarCliente dtoCadastrarCliente);
}