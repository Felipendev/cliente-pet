package br.com.petz.clientepet.pet.infra;

import br.com.petz.clientepet.handler.APIException;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetInfraRepository implements PetRepository {
    private final PetSpringJPARepository petSpringJPARepository;
    @Override
    public Pet salvaPet(Pet pet) {
        log.info("[start] PetInfraRepository - salvaPet");
        petSpringJPARepository.save(pet);
        log.info("[finish] PetInfraRepository - salvaPet");
        return pet;
    }

    @Override
    public List<Pet> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[start] PetInfraRepository - buscaPetsDoClienteComId");
        var pets = petSpringJPARepository.findByIdClienteTutor(idCliente);
        log.info("[finish] PetInfraRepository - buscaPetsDoClienteComId");
        return pets;
    }

    @Override
    public Pet buscaPetPorId(UUID idPet) {
        log.info("[start] PetInfraRepository - buscaPetPorId");
        var pet = petSpringJPARepository.findById(idPet)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Pet não encontrado para o IdPet = " + idPet));
        log.info("[finish] PetInfraRepository - buscaPetPorId");
        return pet;
    }

    @Override
    public void deletaPet(Pet pet) {
        log.info("[start] PetInfraRepository - deletaPetPorId");
        petSpringJPARepository.delete(pet);
        log.info("[finish] PetInfraRepository - deletaPetPorId");
    }
}
