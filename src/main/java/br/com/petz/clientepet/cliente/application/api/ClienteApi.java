package br.com.petz.clientepet.cliente.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/cliente")
public interface ClienteApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    ClienteResponse postCliente(@RequestBody @Valid ClienteRequest clienteRequest);
}
