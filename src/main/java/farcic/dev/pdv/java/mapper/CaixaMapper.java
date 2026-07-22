package farcic.dev.pdv.java.mapper;

import farcic.dev.pdv.java.dto.request.AbrirCaixaRequest;
import farcic.dev.pdv.java.dto.response.CaixaResponse;
import farcic.dev.pdv.java.entity.Caixa;
import farcic.dev.pdv.java.entity.StatusCaixaEnum;
import farcic.dev.pdv.java.entity.Usuario;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CaixaMapper {

    public Caixa toEntity(AbrirCaixaRequest requestDto, Usuario operador){
        return Caixa.builder()
                .valorAbertura(requestDto.valorAbertura())
                .operador(operador)
                .status(StatusCaixaEnum.ABERTO)
                .abertoEm(LocalDateTime.now())
                .build();
    }

    public CaixaResponse toResponse(Caixa entity){
        return CaixaResponse.builder()
                .id(entity.getId())
                .abertoEm(entity.getAbertoEm())
                .fechadoEm(entity.getFechadoEm())
                .valorAbertura(entity.getValorAbertura())
                .valorFechamento(entity.getValorFechamento())
                .operadorId(entity.getOperador().getId())
                .status(entity.getStatus())
                .build();
    }

}
