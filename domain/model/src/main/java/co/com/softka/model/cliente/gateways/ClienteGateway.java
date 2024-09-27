package co.com.softka.model.cliente.gateways;

import co.com.softka.model.cliente.Cliente;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClienteGateway {
    Mono<Cliente> saveClient(Cliente cliente);

    Mono<Cliente> getClientById(Integer idCliente);
    Mono<Cliente> findByIdPersona(Integer idPersona);

    Mono<Void> deleteClientById(Integer id);
}
