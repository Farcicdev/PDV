package farcic.dev.pdv.java.mapper;

import farcic.dev.pdv.java.dto.request.CriarUsuarioRequest;
import farcic.dev.pdv.java.dto.response.CriarUsuarioResponse;
import farcic.dev.pdv.java.entity.PerfilUsuarioEnum;
import farcic.dev.pdv.java.entity.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public Usuario toEntity(CriarUsuarioRequest request) {
        return Usuario.builder()
                .nome(request.nome())
                .email(request.email())
                .senha(request.senha())
                .perfil(PerfilUsuarioEnum.ADMIN)
                .ativo(true)
                .build();
    }

    public CriarUsuarioResponse toResponse(Usuario usuario) {
        return CriarUsuarioResponse.builder()
                .id(usuario.getId())
                .nome(usuario.getNome())
                .email(usuario.getEmail())
                .ativo(usuario.isAtivo())
                .perfil(usuario.getPerfil().name())
                .build();
    }

}
