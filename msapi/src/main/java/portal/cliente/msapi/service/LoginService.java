package portal.cliente.msapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portal.cliente.msapi.dto.TokenDTO;
import portal.cliente.msapi.dto.UsuarioDTO;
import portal.cliente.msapi.entity.Usuario;
import portal.cliente.msapi.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class LoginService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    public TokenDTO login(String email, String senha) throws Exception {
        Usuario usuario = usuarioRepository.findByEmail(email).get();

        if (usuario != null && encoder.matches(senha, usuario.getSenha())) {
            return TokenDTO.builder()
                    .token("Passou")
                    .role(usuario.getRole())
                    .build();
        }
        usuario.setCpf("");

        throw new Exception("Usuário ou senha inválidos");

    }

    public UsuarioDTO login(String email) throws Exception {
        Usuario usuario = usuarioRepository.findByEmail(email).get();
        if (usuario != null) {
            return UsuarioDTO.builder()
                    .id(usuario.getId())
                    .nome(usuario.getNome())
                    .email(usuario.getEmail())
                    .build();
        }

        throw new Exception("Usuário ou senha inválidos");
    }


}
