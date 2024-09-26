package co.com.softka.r2dbc.persona;

import co.com.softka.model.persona.Persona;
import co.com.softka.model.persona.gateways.PersonaGateway;
import co.com.softka.r2dbc.persona.entity.PersonaEntity;
import co.com.softka.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class PersonaAdapter extends ReactiveAdapterOperations<Persona, PersonaEntity, Integer, PersonaRepository>
        implements PersonaGateway {
    public PersonaAdapter(PersonaRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Persona.class));
    }

    @Override
    public Mono<Persona> getPersonByIdentification(String identification) {
        return this.repository.findByIdentification(identification)
                .map(this::toEntity);
    }
}
