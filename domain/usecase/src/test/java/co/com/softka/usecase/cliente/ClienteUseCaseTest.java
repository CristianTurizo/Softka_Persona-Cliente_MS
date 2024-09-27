package co.com.softka.usecase.cliente;

import co.com.softka.model.cliente.Cliente;
import co.com.softka.model.cliente.gateways.ClienteGateway;
import co.com.softka.model.exception.BussinesException;
import co.com.softka.model.exception.Message;
import co.com.softka.model.persona.Persona;
import co.com.softka.usecase.factory.DataFactory;
import co.com.softka.usecase.persona.PersonaUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClienteUseCaseTest {

    @Mock
    private PersonaUseCase personaUseCase;
    @Mock
    private ClienteGateway clienteGateway;

    private ClienteUseCase clienteUseCase;

    @BeforeEach
    public void setUp() {
        clienteUseCase = new ClienteUseCase(personaUseCase, clienteGateway);
    }

    @Test
    void saveClientWithSuccess() {
        Cliente expectedCliente = DataFactory.createCompleteClient();

        when(personaUseCase.findPersonByDocument(any())).thenReturn(Mono.just(DataFactory.createPerson()));
        when(clienteGateway.saveClient(any())).thenReturn(Mono.just(DataFactory.createSavedClient()));

        Mono<Cliente> cliente = clienteUseCase.saveClient(DataFactory.createClientForSave());

        StepVerifier.create(cliente)
                .expectNextMatches(response ->
                        response.getIdCliente().equals(expectedCliente.getIdCliente()) &&
                                response.getIdPersona().equals(expectedCliente.getIdPersona()) &&
                                response.getNombre().equals(expectedCliente.getNombre()) &&
                                response.getGenero().equals(expectedCliente.getGenero()) &&
                                response.getEdad().equals(expectedCliente.getEdad()) &&
                                response.getIdentification().equals(expectedCliente.getIdentification()) &&
                                response.getDireccion().equals(expectedCliente.getDireccion()) &&
                                response.getTelefono().equals(expectedCliente.getTelefono()) &&
                                response.getEstado().equals(expectedCliente.getEstado())
                )
                .verifyComplete();
    }

    @Test
    void saveClientWithPersonNotFound() {

        when(personaUseCase.findPersonByDocument(any())).thenReturn(Mono.empty());

        Mono<Cliente> responseMono = clienteUseCase.saveClient(DataFactory.createClientForSave());

        StepVerifier.create(responseMono)
                .expectErrorMatches(throwable -> {
                    if (throwable instanceof BussinesException) {
                        BussinesException businessException = (BussinesException) throwable;
                        return businessException.getMessage().equals(Message.PERSON_NOT_FOUND.getMessage());
                    }
                    return false;
                })
                .verify();

        verify(clienteGateway, never()).saveClient(any());
    }
}