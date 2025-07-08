package portal.cliente.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import portal.cliente.api.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import portal.cliente.api.dto.ClienteDTO;
import portal.cliente.api.model.Cliente;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository repository;

    public Cliente salvar(ClienteDTO dto) {
        Cliente cliente = Cliente.builder()
                .nome(dto.nome())
                .email(dto.email())
                .cpf(dto.cpf())
                .build();
        return repository.save(cliente);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
