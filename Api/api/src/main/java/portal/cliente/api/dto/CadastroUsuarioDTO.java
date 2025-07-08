package portal.cliente.api.dto;

import jakarta.validation.constraints.NotBlank;

public record CadastroUsuarioDTO(
        @NotBlank(message = "Login é obrigatório")
        String login,

        @NotBlank(message = "Senha é obrigatória")
        String senha,

        String role
) {}
