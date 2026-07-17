package farcic.dev.pdv.java.controller;

import farcic.dev.pdv.java.dto.request.AbrirCaixaRequestDto;
import farcic.dev.pdv.java.dto.response.AbrirCaixaResponseDto;
import farcic.dev.pdv.java.service.CaixaService;
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
    public AbrirCaixaResponseDto abrirCaixa(@RequestBody AbrirCaixaRequestDto requestDto) {
        return service.abrirCaixa(requestDto);
    }

    @PutMapping("/fechar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AbrirCaixaResponseDto fecharCaixa(@PathVariable Long id) {
        return service.closeCaixa(id);
    }

    @GetMapping("/listar")
    @ResponseStatus(HttpStatus.OK)
    public List<AbrirCaixaResponseDto> listarCaixas() {
        return service.listAll();
    }

}
