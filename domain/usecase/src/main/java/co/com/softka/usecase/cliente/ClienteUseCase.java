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
import reactor.function.TupleUtils;

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

    public Mono<Void> updateClient(Cliente cliente) {
        return this.clienteRepository.getClientById(cliente.getIdCliente())
                .switchIfEmpty(Mono.error(new BussinesException(Message.CLIENT_NOT_FOUND)))
                .doOnNext(existedClient-> cliente.setIdPersona(existedClient.getIdPersona()))
                .flatMap(this.clienteRepository::saveClient)
                .then();
    }

    public Mono<Cliente> getClientById(Integer id) {
        return this.clienteRepository.getClientById(id)
                .switchIfEmpty(Mono.error(new BussinesException(Message.CLIENT_NOT_FOUND)))
                .flatMap(client -> Mono.just(client).zipWith(this.personaUseCase.findPersonById(client.getIdPersona())))
                .map(TupleUtils.function(this::buildClient));
    }

    public Mono<Void> deleteClientById(Integer id) {
        return this.clienteRepository.getClientById(id)
                .switchIfEmpty(Mono.error(new BussinesException(Message.CLIENT_NOT_FOUND)))
                .then(this.clienteRepository.deleteClientById(id));
    }


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

}
