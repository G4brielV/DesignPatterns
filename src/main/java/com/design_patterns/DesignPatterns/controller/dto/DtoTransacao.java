package com.design_patterns.DesignPatterns.controller.dto;

import java.math.BigDecimal;

public record DtoTransacao(
        String tipo,
        Long remetenteId,
        Long destinatarioId,
        BigDecimal valor
) {
}
