package farcic.dev.pdv.java.mapper;

import farcic.dev.pdv.java.dto.request.CadastroProdutoRequest;
import farcic.dev.pdv.java.dto.response.CadastroProdutoResponse;
import farcic.dev.pdv.java.entity.Produto;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    public Produto toEntity(CadastroProdutoRequest request) {
        return Produto.builder()
                .nome(request.nome())
                .codigoBarras(request.codigoBarras())
                .preco(request.preco())
                .build();
    }

    public CadastroProdutoResponse toResponse(Produto produto) {
        return CadastroProdutoResponse.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .codigoBarras(produto.getCodigoBarras())
                .preco(produto.getPreco())
                .ativo(produto.getAtivo())
                .build();

    }
}
