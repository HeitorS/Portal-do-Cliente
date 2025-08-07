package portal.cliente.msapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import portal.cliente.msapi.util.RoleEnum;

import java.sql.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    private String telefone;

    private String cpf;

    private Date nascimento;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    private String cadastro;

    private String atualizacao;

    private String status;
}
