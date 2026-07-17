package farcic.dev.pdv.java.controller;

import farcic.dev.pdv.java.dto.request.AbrirCaixaRequestDto;
import farcic.dev.pdv.java.dto.response.AbrirCaixaResponseDto;
import farcic.dev.pdv.java.service.CaixaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

}
