package portal.cliente.api.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import portal.cliente.api.repository.UsuarioRepository;
import portal.cliente.api.dto.CadastroUsuarioDTO;
import org.springframework.stereotype.Service;
import portal.cliente.api.model.Usuario;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    public Usuario cadastrar(CadastroUsuarioDTO dto) {
        Usuario usuario = Usuario.builder()
                .login(dto.login())
                .senha(dto.senha())
                .role(dto.role() == null ? "ROLE_USER" : dto.role())
                .build();

        return repository.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = repository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return User.builder()
                .username(usuario.getLogin())
                .password(usuario.getSenha())
                .roles(usuario.getRole().replace("ROLE_", ""))
                .build();
    }

    public String encodePassword(String password) {
        return encoder.encode(password);
    }
}
