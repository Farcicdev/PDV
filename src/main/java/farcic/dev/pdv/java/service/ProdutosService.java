package farcic.dev.pdv.java.service;

import farcic.dev.pdv.java.dto.request.CadastroProdutoRequest;
import farcic.dev.pdv.java.dto.response.CadastroProdutoResponse;
import farcic.dev.pdv.java.entity.Produto;
import farcic.dev.pdv.java.exeption.CodigoBarrasJaExisteException;
import farcic.dev.pdv.java.mapper.ProdutoMapper;
import farcic.dev.pdv.java.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProdutosService {

    private final ProdutoRepository produtoRepository;

    private final ProdutoMapper produtoMapper;

    public CadastroProdutoResponse criarProduto(CadastroProdutoRequest request) {
        Produto entity = produtoMapper.toEntity(request);

        if(produtoRepository.existsByCodigoBarras(entity.getCodigoBarras())) {
            throw new CodigoBarrasJaExisteException("Código de barras já existe.");
        }
        entity.setAtivo(true);
        Produto savedEntity = produtoRepository.save(entity);
        return produtoMapper.toResponse(savedEntity);
    }

    public Page<CadastroProdutoResponse> listarProdutos(Pageable pageable) {
        return produtoRepository.findAll(pageable)
                .map(produtoMapper::toResponse);
    }

}
