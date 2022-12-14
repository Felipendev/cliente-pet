package br.com.petz.clientepet.pet.application.repository;

import br.com.petz.clientepet.pet.domain.Pet;

import java.util.List;
import java.util.UUID;

public interface PetRepository {
    Pet salvaPet(Pet pet);
    List<Pet> buscaPetsDoClienteComId(UUID idCliente);
    Pet buscaPetPorId(UUID idPet);
    void deletaPet(Pet pet);
}
