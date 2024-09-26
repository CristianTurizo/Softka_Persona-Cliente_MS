package co.com.softka.usecase.cliente;

import co.com.softka.model.cliente.Cliente;
import co.com.softka.model.cliente.gateways.ClienteGateway;
import co.com.softka.usecase.persona.PersonaUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ClienteUseCase {
    private final PersonaUseCase personaUseCase;
    private final ClienteGateway clienteRepository;

    public Mono<Void> saveClient(Cliente cliente) {
        return Mono.empty();
    }

    ;

    public Mono<Void> updateClient(Cliente cliente) {
        return Mono.empty();
    }

    public Mono<Cliente> getClientById(Integer id) {
        return Mono.just(Cliente.builder().build());
    }

    public Flux<Cliente> getAllClients() {
        return Flux.empty();
    }

}
