package farcic.dev.pdv.java.dto.response;

import lombok.Builder;

@Builder
public record CriarUsuarioResponse(

        Long id,
        String nome,
        String email,
        boolean ativo,
        String perfil

){
}
