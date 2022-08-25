package br.com.petz.clientepet.cliente.infra;

import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import br.com.petz.clientepet.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ClienteInfraRepository implements ClienteRepository {
    private final ClienteSpringDataJPARepository clienteSpringDataJPARepository;

    @Override
    public Cliente salva(Cliente cliente) {
       log.info("[start] ClienteInfraRepository - salva");
       try {
           clienteSpringDataJPARepository.save(cliente);
       } catch (DataIntegrityViolationException e) {
           throw APIException.build(HttpStatus.BAD_REQUEST, "Existem dados duplicados! ", e);
       }
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

    @Override
    public Cliente buscaClienteAtravesId(UUID idCliente) {
        log.info("[start] ClienteInfraRepository - buscaClienteAtravesId");
        Cliente cliente = clienteSpringDataJPARepository.findById(idCliente)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
        log.info("[finish] ClienteInfraRepository - buscaClienteAtravesId");
        return cliente;
    }

    @Override
    public void deletaCliente(Cliente cliente) {
        log.info("[start] ClienteInfraRepository - deletaCliente");
        clienteSpringDataJPARepository.delete(cliente);
        log.info("[finish] ClienteInfraRepository - deletaCliente");
    }
}
