package com.design_patterns.DesignPatterns.service.Cliente;

import com.design_patterns.DesignPatterns.model.Cliente.Cliente;
import com.design_patterns.DesignPatterns.model.Cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> detalharCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public void cadastrarCliente(DtoCadastrarCliente dtoCadastrarCliente){
        Cliente novoCliente = new Cliente();
        novoCliente.setNome(dtoCadastrarCliente.nome());
        clienteRepository.save(novoCliente);
    }
}
