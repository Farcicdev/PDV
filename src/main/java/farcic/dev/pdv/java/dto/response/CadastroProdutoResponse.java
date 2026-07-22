package farcic.dev.pdv.java.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public record CadastroProdutoResponse(

        Long id,
        String nome,
        String codigoBarras,
        BigDecimal preco,
        Boolean ativo

) {
}
