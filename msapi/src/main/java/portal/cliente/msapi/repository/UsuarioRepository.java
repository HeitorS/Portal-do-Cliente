package portal.cliente.msapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portal.cliente.msapi.entity.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByCpf(String cpf);
}
