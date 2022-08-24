package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.pet.application.api.PetClienteDetalhaResponse;
import br.com.petz.clientepet.pet.application.api.PetClienteListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;

import java.util.List;
import java.util.UUID;

public interface PetService{
    PetResponse criaPet(UUID idCliente, PetRequest petRequest);
    List<PetClienteListResponse> buscaPetsDoClienteComId(UUID idCliente);
    PetClienteDetalhaResponse buscaPetDoClienteComId(UUID idCliente, UUID idPet);
}
