package br.com.petz.clientepet.pet.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/cliente/{idCliente}/pet")
public interface PetApi {
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    PetResponse postPet(@PathVariable UUID idCliente, @RequestBody  @Valid PetRequest petRequest);

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    List<PetClienteListResponse> getPetsDoClienteComId(@PathVariable UUID idCliente);

    @GetMapping(value = "/{idPet}")
    @ResponseStatus(code = HttpStatus.OK)
    PetClienteDetalhaResponse getPetDoClienteComId(@PathVariable UUID idCliente, @PathVariable UUID idPet);

    @PatchMapping(value = "/{idPet}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    PetResponse patchPetRequest(@PathVariable UUID idCliente, @PathVariable UUID idPet, @RequestBody  @Valid PetAlteracaoRequest petAlteracaoRequest);

    @DeleteMapping(value = "/{idPet}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    void deletePetDoClienteComId(@PathVariable UUID idCliente, @PathVariable UUID idPet);
}
