package co.com.softka.usecase.cliente;

import co.com.softka.model.cliente.Cliente;
import co.com.softka.model.cliente.gateways.ClienteGateway;
import co.com.softka.model.exception.BussinesException;
import co.com.softka.model.exception.Message;
import co.com.softka.model.persona.Persona;
import co.com.softka.usecase.persona.PersonaUseCase;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class ClienteUseCase {
    private final PersonaUseCase personaUseCase;
    private final ClienteGateway clienteRepository;

    public Mono<Cliente> saveClient(Cliente cliente) {
        return this.personaUseCase.findPersonByDocument(cliente.getIdentification())
                .switchIfEmpty(Mono.error(new BussinesException(Message.PERSON_NOT_FOUND)))
                .doOnNext(person -> {
                    cliente.setIdPersona(person.getIdPersona());
                    cliente.setEstado(true);
                    cliente.setIdPersona(person.getIdPersona());
                })
                .flatMap(person -> this.clienteRepository.saveClient(cliente)
                        .map(savedClient -> this.buildClient(savedClient, person)));
    }

    ;

    private Cliente buildClient(Cliente client, Persona person) {
        return client.toBuilder()
                .nombre(person.getNombre())
                .genero(person.getGenero())
                .edad(person.getEdad())
                .identification(person.getIdentification())
                .direccion(person.getDireccion())
                .telefono(person.getTelefono())
                .password("++++")
                .build();
    }

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
