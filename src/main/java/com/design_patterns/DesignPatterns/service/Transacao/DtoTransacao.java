package com.design_patterns.DesignPatterns.service.Transacao;

import java.math.BigDecimal;

public record DtoTransacao(
        String tipo,
        Long remetenteId,
        Long destinatarioId,
        BigDecimal valor
) {
}
