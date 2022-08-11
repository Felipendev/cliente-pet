package br.com.petz.clientepet.pet.infra;

import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

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
}
