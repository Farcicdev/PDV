package farcic.dev.pdv.java.service;

import farcic.dev.pdv.java.dto.request.AbrirCaixaRequestDto;
import farcic.dev.pdv.java.dto.response.AbrirCaixaResponseDto;
import farcic.dev.pdv.java.entity.Caixa;
import farcic.dev.pdv.java.entity.Usuario;
import farcic.dev.pdv.java.mapper.CaixaMapper;
import farcic.dev.pdv.java.repository.CaixaRepository;
import farcic.dev.pdv.java.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CaixaService {

    private final CaixaRepository caixaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CaixaMapper mapper;

    public AbrirCaixaResponseDto abrirCaixa(AbrirCaixaRequestDto request) {
        Usuario operador = usuarioRepository.findById(request.operadorId())
                .orElseThrow(() -> new RuntimeException("Operador não encontrado"));

        Caixa entity = mapper.toEntity(request, operador);
        Caixa saved = caixaRepository.save(entity);
        return mapper.toResponse(saved);
    }

}
