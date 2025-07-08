package portal.cliente.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import portal.cliente.api.service.ClienteService;
import portal.cliente.api.dto.ClienteDTO;
import portal.cliente.api.model.Cliente;
import jakarta.validation.Valid;


import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public Cliente salvar(@RequestBody @Valid ClienteDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<Cliente> listar() {
        return service.listar();
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id) {
        service.excluir(id);
    }
}

