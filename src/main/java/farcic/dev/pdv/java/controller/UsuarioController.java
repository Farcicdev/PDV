package farcic.dev.pdv.java.controller;

import farcic.dev.pdv.java.dto.request.CriarUsuarioRequest;
import farcic.dev.pdv.java.dto.response.CriarUsuarioResponse;
import farcic.dev.pdv.java.service.CriarUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final CriarUsuarioService criarUsuarioService;

    @PostMapping("/cadastrar")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public CriarUsuarioResponse cadastrarUsuario(@RequestBody CriarUsuarioRequest request) {
        return criarUsuarioService.saveUser(request);
    }
}
