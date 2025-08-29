package portal.cliente.msapi.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import portal.cliente.msapi.util.RoleEnum;
import jakarta.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.List;

import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario implements UserDetails {

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

    @Column(nullable = false)
    private String cpf;

    private Date nascimento;

    @Enumerated(EnumType.STRING)
    private RoleEnum role;

    private String cadastro;

    private String atualizacao;

    private String status;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role == RoleEnum.ADMIN) {
            return List.of( new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }
}
