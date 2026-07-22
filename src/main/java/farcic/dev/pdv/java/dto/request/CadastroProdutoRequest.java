package farcic.dev.pdv.java.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CadastroProdutoRequest(

        @NotBlank(message = "O nome do produto é obrigatório")
        @Size(max = 120, message = "O nome do produto deve ter no máximo 120 caracteres")
        String nome,

        @Size(max = 60, message = "O código de barras deve ter no máximo 60 caracteres")
        String codigoBarras,

        @NotNull(message = "O preço do produto é obrigatório")
        @DecimalMin(value = "0.00", message = "O preço do produto não pode ser negativo")
        @Digits(integer = 8, fraction = 2, message = "O preço deve ter no máximo 8 dígitos inteiros e 2 casas decimais")
        BigDecimal preco

) {
}
