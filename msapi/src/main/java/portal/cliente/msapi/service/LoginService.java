package portal.cliente.msapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import portal.cliente.msapi.dto.TokenDTO;
import portal.cliente.msapi.entity.Usuario;
import portal.cliente.msapi.exception.UsuarioNotFoundException;
import portal.cliente.msapi.repository.UsuarioRepository;
import portal.cliente.msapi.security.JwtUtil;

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
            JwtUtil jwtUtil = new JwtUtil();
            String token = jwtUtil.gerarToken(user.getEmail());
            return TokenDTO.builder()
                    .token(token)
                    .role(user.getRole().name())
                    .timeout(System.currentTimeMillis() + 3600000) // 1 hour expiration
                    .build();
        }
        return null;
    }

    public Usuario valid(String username) throws UsuarioNotFoundException {
        return usuarioRepository.findByEmail(username)
                .orElseThrow(() -> new UsuarioNotFoundException());
    }

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
