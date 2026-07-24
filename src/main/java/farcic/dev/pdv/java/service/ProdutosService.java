package farcic.dev.pdv.java.service;

import farcic.dev.pdv.java.dto.request.CadastroProdutoRequest;
import farcic.dev.pdv.java.dto.request.UpdateProdutosRequest;
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

    public CadastroProdutoResponse atualizarProdutos(Long id, UpdateProdutosRequest request){
        Produto produtoId = produtoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado com o ID: " + id));

        produtoId.setNome(request.nome());
        produtoId.setCodigoBarras(request.codigoBarras());
        produtoId.setPreco(request.preco());
        produtoId.setAtivo(request.ativo());

        Produto updatedProduto = produtoRepository.save(produtoId);
        return produtoMapper.toResponse(updatedProduto);
    }
}
