package portal.cliente.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portal.cliente.api.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByCpf(String cpf);
}
