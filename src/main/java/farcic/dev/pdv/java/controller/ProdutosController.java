package farcic.dev.pdv.java.controller;

import farcic.dev.pdv.java.dto.request.CadastroProdutoRequest;
import farcic.dev.pdv.java.dto.request.UpdateProdutosRequest;
import farcic.dev.pdv.java.dto.response.CadastroProdutoResponse;
import farcic.dev.pdv.java.service.ProdutosService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
public class ProdutosController {

    private final ProdutosService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CadastroProdutoResponse criarProduto(@RequestBody @Valid CadastroProdutoRequest request) {
        return service.criarProduto(request);
    }

    @GetMapping
    public Page<CadastroProdutoResponse> listarProdutos(Pageable pageable) {
        return service.listarProdutos(pageable);
    }

    @PutMapping("/alterar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CadastroProdutoResponse atulizarCadastro(@PathVariable Long id, @RequestBody @Valid UpdateProdutosRequest request){
        return service.atualizarProdutos(id, request);
    }

}
