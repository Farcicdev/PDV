package farcic.dev.pdv.java.service;

import farcic.dev.pdv.java.dto.request.AbrirCaixaRequest;
import farcic.dev.pdv.java.dto.request.FecharCaixaRequest;
import farcic.dev.pdv.java.dto.response.CaixaResponse;
import farcic.dev.pdv.java.entity.Caixa;
import farcic.dev.pdv.java.entity.StatusCaixaEnum;
import farcic.dev.pdv.java.entity.Usuario;
import farcic.dev.pdv.java.exeption.CashRegisterAlreadyOpenException;
import farcic.dev.pdv.java.mapper.CaixaMapper;
import farcic.dev.pdv.java.repository.CaixaRepository;
import farcic.dev.pdv.java.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CaixaService {

    private final CaixaRepository caixaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CaixaMapper mapper;

    public CaixaResponse abrirCaixa(AbrirCaixaRequest request) {
        Usuario operador = usuarioRepository.findById(request.operadorId())
                .orElseThrow(() -> new CashRegisterAlreadyOpenException("Operador não encontrado"));

        boolean possuiCaixaAberto = caixaRepository.existsByOperadorIdAndStatus(operador.getId(), StatusCaixaEnum.ABERTO);

        if (possuiCaixaAberto) {
            throw new CashRegisterAlreadyOpenException("O operador já possui um caixa aberto.");
        }

        Caixa entity = mapper.toEntity(request, operador);
        Caixa saved = caixaRepository.save(entity);
        return mapper.toResponse(saved);
    }

    public List<CaixaResponse> listAll() {
        List<Caixa> caixas = caixaRepository.findAll();
        return caixas.stream()
                .map(mapper::toResponse)
                .toList();
    }

    public CaixaResponse closeCaixa(Long id, FecharCaixaRequest request){

        Caixa caixa = caixaRepository.findById(id)
                .orElseThrow(() -> new CashRegisterAlreadyOpenException("Caixa não encontrado"));

        if (caixa.getStatus() == StatusCaixaEnum.FECHADO) {
            throw new CashRegisterAlreadyOpenException("O caixa já está fechado.");
        }

        caixa.setValorFechamento(request.valorFechamento());
        caixa.setFechadoEm(LocalDateTime.now());
        caixa.setStatus(StatusCaixaEnum.FECHADO);
        Caixa saved = caixaRepository.save(caixa);
        return mapper.toResponse(saved);
    }

}
