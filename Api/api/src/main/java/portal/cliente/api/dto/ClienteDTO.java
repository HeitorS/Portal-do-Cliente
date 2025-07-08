package portal.cliente.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;

public record ClienteDTO (
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @Email(message = "Email inválido")
        String email,

        @NotBlank(message = "CPF é obrigatório")
        String cpf
) {}
