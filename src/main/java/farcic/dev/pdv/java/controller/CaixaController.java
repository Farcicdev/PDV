package farcic.dev.pdv.java.controller;

import farcic.dev.pdv.java.dto.request.AbrirCaixaRequestDto;
import farcic.dev.pdv.java.dto.response.AbrirCaixaResponseDto;
import farcic.dev.pdv.java.service.CaixaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/caixa")
@RequiredArgsConstructor
public class CaixaController {

    private final CaixaService service;

    @PostMapping("/abrir")
    @ResponseStatus(HttpStatus.CREATED)
    public AbrirCaixaResponseDto abrirCaixa(AbrirCaixaRequestDto requestDto) {
        return service.abrirCaixa(requestDto);
    }

}
