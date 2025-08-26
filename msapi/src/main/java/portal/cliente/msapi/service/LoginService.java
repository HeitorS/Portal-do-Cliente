package portal.cliente.msapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portal.cliente.msapi.dto.TokenDTO;
import portal.cliente.msapi.entity.Usuario;
import portal.cliente.msapi.exception.UsuarioNotFoundException;
import portal.cliente.msapi.repository.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class LoginService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public TokenDTO login(String username, String password) throws UsuarioNotFoundException {
        Usuario user = usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsuarioNotFoundException());
        if (passwordEncoder.matches(password, user.getSenha())) {
            return TokenDTO.builder()
                    .token("fake-jwt-token")
                    .role(user.getRole().name())
                    .timeout(System.currentTimeMillis() + 3600000) // 1 hour expiration
                    .build();
        }
        return null;
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
