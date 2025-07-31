package portal.cliente.msapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

import java.sql.Date;

@Builder
public record UsuarioDTO (
        String id,
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @NotBlank(message = "Email é obrigatório")
        String email,

        String senha,
        String confirmacaoSenha,

        @NotBlank(message = "Telefone é obrigatório")
        String telefone,

        @NotBlank(message = "CPF é obrigatório")
        String cpf,

        @NotBlank(message = "Data de nascimento é obrigatória")
        Date dataNascimento,

        String role,
        Date dataCadastro,
        Date dataAtualizacao,

        @NotBlank(message = "Status é obrigatório")
        char status
){
}
