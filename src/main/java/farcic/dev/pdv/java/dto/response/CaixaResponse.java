package farcic.dev.pdv.java.dto.response;

import farcic.dev.pdv.java.entity.StatusCaixaEnum;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record CaixaResponse(
        Long id,
        LocalDateTime abertoEm,
        LocalDateTime fechadoEm,
        BigDecimal valorAbertura,
        BigDecimal valorFechamento,
        StatusCaixaEnum status,
        Long operadorId
) {
}
