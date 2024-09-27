package co.com.softka.r2dbc.cliente;

import co.com.softka.model.cliente.Cliente;
import co.com.softka.model.cliente.gateways.ClienteGateway;
import co.com.softka.r2dbc.cliente.entity.ClienteEntity;
import co.com.softka.r2dbc.helper.ReactiveAdapterOperations;
import lombok.extern.slf4j.Slf4j;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Repository
public class ClienteAdapter extends ReactiveAdapterOperations<Cliente, ClienteEntity, Integer, ClienteRepository>
        implements ClienteGateway {
    public ClienteAdapter(ClienteRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Cliente.class));
    }

    @Override
    public Mono<Cliente> saveClient(Cliente cliente) {
        return this.save(cliente)
                .doFirst(() -> log.info("Saving client"))
                .doOnError(e -> log.error("Error saving client -> {}", e.getMessage()));
    }

    @Override
    public Mono<Cliente> getClientById(Integer idCliente) {
        return this.findById(idCliente)
                .doFirst(() -> log.info("Finding client with id: {}", idCliente))
                .doOnError(error -> log.error("Error finding client with id: {} -> {}", idCliente, error.getMessage()));
    }

    @Override
    public Mono<Cliente> findByIdPersona(Integer idPersona) {
        return this.repository.findByIdPersona(idPersona)
                .map(this::toEntity)
                .doFirst(() -> log.info("Finding client with idPersona: {}", idPersona))
                .doOnError(error -> log.error("Error finding client with idPersona: {} -> {}", idPersona, error.getMessage()));
    }

    @Override
    public Mono<Void> deleteClientById(Integer id) {
        return this.repository.deleteById(id)
                .doFirst(() -> log.info("Deleting client with id: {}", id))
                .doOnError(error -> log.error("Error deleting client with idPersona: {} -> {}", id, error.getMessage()));
    }
}
