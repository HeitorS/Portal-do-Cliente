package portal.cliente.msapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 255, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(nullable = false, length = 15)
    private String telefone;

    @Column(nullable = false, length = 15, unique = true)
    private String cpf;

    @Column(nullable = false)
    private Date nascimento;

    @Column(nullable = false, length = 50)
    private String role = "ROLE_USER";

    @Column(nullable = false, length = 20)
    private Date cadastro = new Date(System.currentTimeMillis());

    @Column(nullable = false, length = 20)
    private Date atualizacao = new Date(System.currentTimeMillis());

    @Column(nullable = false, length = 1)
    private char status = 'S';
}
