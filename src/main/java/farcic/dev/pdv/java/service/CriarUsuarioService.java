package farcic.dev.pdv.java.service;

import farcic.dev.pdv.java.dto.request.CriarUsuarioRequest;
import farcic.dev.pdv.java.dto.response.CriarUsuarioResponse;
import farcic.dev.pdv.java.entity.Usuario;
import farcic.dev.pdv.java.exeption.EmailAreadyExistException;
import farcic.dev.pdv.java.mapper.UsuarioMapper;
import farcic.dev.pdv.java.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CriarUsuarioService {

    private final UsuarioRepository repository;
    private final UsuarioMapper usuarioMapper;

    public CriarUsuarioResponse saveUser(CriarUsuarioRequest request){
        Usuario entity = usuarioMapper.toEntity(request);

        if(repository.existsByEmail(entity.getEmail())){
            throw new EmailAreadyExistException("Email já cadastrado");
        }

        Usuario save = repository.save(entity);
        return usuarioMapper.toResponse(save);
    }

}
