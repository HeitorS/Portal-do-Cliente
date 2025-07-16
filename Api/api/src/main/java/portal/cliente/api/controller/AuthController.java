package portal.cliente.api.controller;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import portal.cliente.api.service.UsuarioService;
import portal.cliente.api.dto.CadastroUsuarioDTO;
import portal.cliente.api.security.JwtUtil;
import portal.cliente.api.model.Usuario;
import jakarta.validation.Valid;


import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200/*")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Usuario usuario) {
        Authentication auth = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(usuario.getLogin(), usuario.getSenha())
        );

        User user = (User) auth.getPrincipal();
        String token = jwtUtil.gerarToken(user.getUsername());
        return Map.of("token", token);
    }

    @PostMapping("/register")
    public Usuario registrar(@RequestBody @Valid CadastroUsuarioDTO dto) {
        return usuarioService.cadastrar(dto);
    }
}