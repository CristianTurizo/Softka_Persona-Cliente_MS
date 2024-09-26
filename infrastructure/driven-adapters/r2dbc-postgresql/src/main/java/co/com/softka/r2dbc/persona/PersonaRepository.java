package co.com.softka.r2dbc.persona;

import co.com.softka.r2dbc.persona.entity.PersonaEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface PersonaRepository extends ReactiveCrudRepository<PersonaEntity, Integer>, ReactiveQueryByExampleExecutor<PersonaEntity> {
    Mono<PersonaEntity> findByIdentification(String identification);

}
