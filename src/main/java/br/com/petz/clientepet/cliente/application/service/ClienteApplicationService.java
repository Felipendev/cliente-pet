package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.*;
import br.com.petz.clientepet.cliente.application.repository.ClienteRepository;
import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ClienteApplicationService implements ClienteService {
    private final ClienteRepository clienteRepository;

    @Override
    public ClienteResponse criaCliente(ClienteRequest clienteRequest) {
        log.info("[start] ClienteApplicationService - criaCliente");
        Cliente cliente = clienteRepository.salva(new Cliente(clienteRequest));
        log.info("[finish] ClienteApplicationService - criaCliente");
        return ClienteResponse.builder().idCliente(cliente.getIdCliente()).build();
    }

    @Override
    public List<ClienteListResponse> buscaTodosClientes() {
        log.info("[start] ClienteApplicationService - buscasTodosClientes");
        List<Cliente> clientes = clienteRepository.buscaTodosOsClientes();
        log.info("[finish] ClienteApplicationService - buscasTodosClientes");
        return ClienteListResponse.converte(clientes);
    }

    @Override
    public ClienteDetalhadoResponse buscaClienteAtravesId(UUID idCliente) {
        log.info("[start] ClienteApplicationService - buscaClienteAtravesId");
        Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
        log.info("[finish] ClienteApplicationService - buscaClienteAtravesId");
        return new ClienteDetalhadoResponse(cliente);
    }

    @Override
    public void deletaClienteAtravesId(UUID idCliente) {
        log.info("[start] ClienteApplicationService - deletaClienteAtravesId");
        Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
        clienteRepository.deletaCliente(cliente);
        log.info("[finish] ClienteApplicationService - deletaClienteAtravesId");
    }

    @Override
    public void patchAlteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest) {
        log.info("[start] ClienteApplicationService - patchAlteraCliente");
        Cliente cliente = clienteRepository.buscaClienteAtravesId(idCliente);
        cliente.altera(clienteAlteracaoRequest);
        clienteRepository.salva(cliente);
        log.info("[finish] ClienteApplicationService - patchAlteraCliente");
    }
}
