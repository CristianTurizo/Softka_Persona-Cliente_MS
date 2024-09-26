package co.com.softka.r2dbc.cliente;

import co.com.softka.r2dbc.cliente.entity.ClienteEntity;
import co.com.softka.r2dbc.persona.entity.PersonaEntity;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveCrudRepository<ClienteEntity, Integer>, ReactiveQueryByExampleExecutor<ClienteEntity> {

}
