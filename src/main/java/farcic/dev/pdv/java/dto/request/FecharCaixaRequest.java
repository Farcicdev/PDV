package farcic.dev.pdv.java.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record FecharCaixaRequest(
        @NotNull
        @DecimalMin("0.00")
        BigDecimal valorFechamento
) {
}
