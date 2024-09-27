package co.com.softka.r2dbc.persona;

import co.com.softka.model.persona.Persona;
import co.com.softka.model.persona.gateways.PersonaGateway;
import co.com.softka.r2dbc.helper.ReactiveAdapterOperations;
import co.com.softka.r2dbc.persona.entity.PersonaEntity;
import lombok.extern.slf4j.Slf4j;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class PersonaAdapter extends ReactiveAdapterOperations<Persona, PersonaEntity, Integer, PersonaRepository>
        implements PersonaGateway {
    public PersonaAdapter(PersonaRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Persona.class));
    }

    @Override
    public Mono<Persona> getPersonByIdentification(String identification) {
        return this.repository.findByIdentification(identification)
                .map(this::toEntity)
                .doFirst(() -> log.info("Finding Person with identification: {}", identification))
                .doOnError(e -> log.error("Error finding person with identification: {} -> {}", identification, e.getMessage()));
    }

    @Override
    public Mono<Persona> getPersonById(Integer id) {
        return this.findById(id)
                .doFirst(() -> log.info("Finding Person with id: {}", id))
                .doOnError(e -> log.error("Error finding person with id: {} -> {}", id, e.getMessage()));
    }
}
