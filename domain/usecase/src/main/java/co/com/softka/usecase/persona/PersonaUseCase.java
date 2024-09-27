package co.com.softka.usecase.persona;

import co.com.softka.model.persona.Persona;
import co.com.softka.model.persona.gateways.PersonaGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class PersonaUseCase {
    private final PersonaGateway personaRepository;

    public Mono<Persona> findPersonByDocument(String identification) {
        return personaRepository.getPersonByIdentification(identification);
    }

    public Mono<Persona> findPersonById(Integer id) {
        return personaRepository.getPersonById(id);
    }
}
