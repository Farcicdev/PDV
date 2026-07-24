package farcic.dev.pdv.java.controller;

import farcic.dev.pdv.java.dto.request.AbrirCaixaRequest;
import farcic.dev.pdv.java.dto.request.FecharCaixaRequest;
import farcic.dev.pdv.java.dto.response.CaixaResponse;
import farcic.dev.pdv.java.service.CaixaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caixa")
@RequiredArgsConstructor
public class CaixaController {

    private final CaixaService service;

    @PostMapping("/abrir")
    @ResponseStatus(HttpStatus.CREATED)
    public CaixaResponse abrirCaixa(@RequestBody @Valid AbrirCaixaRequest requestDto) {
        return service.abrirCaixa(requestDto);
    }

    @PutMapping("/fechar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CaixaResponse fecharCaixa(@PathVariable Long id, @RequestBody @Valid FecharCaixaRequest valorFechamento) {
        return service.closeCaixa(id, valorFechamento);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<CaixaResponse> listarCaixas() {
        return service.listAll();
    }
}
