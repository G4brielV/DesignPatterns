package com.design_patterns.DesignPatterns.service.Cliente.impl;

import com.design_patterns.DesignPatterns.model.Cliente.Cliente;
import com.design_patterns.DesignPatterns.model.Cliente.ClienteRepository;
import com.design_patterns.DesignPatterns.service.Cliente.DtoCadastrarCliente;
import com.design_patterns.DesignPatterns.service.Cliente.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> detalharCliente(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public void cadastrarCliente(DtoCadastrarCliente dtoCadastrarCliente) {
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(dtoCadastrarCliente.nome());
        clienteRepository.save(novoCliente);
    }

}

