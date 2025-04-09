package com.design_patterns.DesignPatterns.model.Cliente;

import com.design_patterns.DesignPatterns.model.Transacao.Transacao;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "remetente")
    @JsonManagedReference("enviadas")
    private List<Transacao> transacaoEnviadas;

    @OneToMany(mappedBy = "destinatario")
    @JsonManagedReference("recebidas")
    private List<Transacao> transacaoRecebida;

}
