package com.design_patterns.DesignPatterns.model.Transacao;

import com.design_patterns.DesignPatterns.model.Cliente.Cliente;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Entity
@Getter
@Setter
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal valor;
    private LocalDateTime dateTime;
    @Enumerated
    private Tipo tipo;
    private BigDecimal taxa;

    @ManyToOne
    @JoinColumn(name = "remetente_id")
    @JsonBackReference("enviadas")
    private Cliente remetente;
    @ManyToOne
    @JoinColumn(name = "destinatario_id")
    @JsonBackReference("enviadas")
    private Cliente destinatario;

}

