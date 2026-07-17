package farcic.dev.pdv.java.mapper;

import farcic.dev.pdv.java.dto.request.AbrirCaixaRequestDto;
import farcic.dev.pdv.java.dto.response.AbrirCaixaResponseDto;
import farcic.dev.pdv.java.entity.Caixa;
import farcic.dev.pdv.java.entity.StatusCaixaEnum;
import farcic.dev.pdv.java.entity.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CaixaMapper {

    public Caixa toEntity(AbrirCaixaRequestDto requestDto, Usuario operador){
        return Caixa.builder()
                .valorAbertura(requestDto.valorAbertura())
                .operador(operador)
                .status(StatusCaixaEnum.ABERTO)
                .abertoEm(LocalDateTime.now())
                .build();
    }

    public AbrirCaixaResponseDto toResponse(Caixa entity){
        return AbrirCaixaResponseDto.builder()
                .id(entity.getId())
                .abertoEm(entity.getAbertoEm())
                .valorAbertura(entity.getValorAbertura())
                .operadorId(entity.getOperador().getId())
                .status(entity.getStatus())
                .build();
    }

}
