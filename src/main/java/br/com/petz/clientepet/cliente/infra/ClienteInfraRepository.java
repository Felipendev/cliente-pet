package br.com.petz.clientepet.cliente.infra;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Properties;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {


    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
       log.info("[start] ClienteInfraRepository - salva");
       clienteSpringDataJPARepository.save(cliente);
       log.info("[finish] ClienteInfraRepository - salva");
       return cliente;
    }

    @Override
    public List<Cliente> buscaTodosOsClientes() {
        log.info("[start] ClienteInfraRepository - buscaTodosOsClientes");
        List<Cliente> todosClientes = clienteSpringDataJPARepository.findAll();
        log.info("[finish] ClienteInfraRepository - buscaTodosOsClientes");
        return todosClientes;
    }
}
