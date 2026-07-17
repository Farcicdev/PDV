package farcic.dev.pdv.java.dto.request;

public record CriarUsuarioRequest(

        String nome,
        String email,
        String senha,
        String perfil

) {
}
