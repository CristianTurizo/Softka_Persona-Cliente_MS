package co.com.softka.model.persona.gateways;

import co.com.softka.model.persona.Persona;
import reactor.core.publisher.Mono;

public interface PersonaGateway {
    Mono<Persona> getPersonByIdentification(String identification);
}
