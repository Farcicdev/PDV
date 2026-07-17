package farcic.dev.pdv.java.dto.response;

import farcic.dev.pdv.java.entity.StatusCaixaEnum;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record AbrirCaixaResponseDto(
        Long id,
        LocalDateTime abertoEm,
        BigDecimal valorAbertura,
        StatusCaixaEnum status,
        Long operadorId
) {
}
