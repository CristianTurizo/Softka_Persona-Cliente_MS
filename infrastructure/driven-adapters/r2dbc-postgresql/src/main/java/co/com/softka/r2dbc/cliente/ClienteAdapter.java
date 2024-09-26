package co.com.softka.r2dbc.cliente;

import co.com.softka.model.cliente.Cliente;
import co.com.softka.model.cliente.gateways.ClienteGateway;
import co.com.softka.r2dbc.cliente.entity.ClienteEntity;
import co.com.softka.r2dbc.helper.ReactiveAdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class ClienteAdapter extends ReactiveAdapterOperations<Cliente, ClienteEntity, Integer, ClienteRepository>
        implements ClienteGateway {
    public ClienteAdapter(ClienteRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Cliente.class));
    }

    @Override
    public Mono<Cliente> saveClient(Cliente cliente) {
        return this.save(cliente);
    }

    @Override
    public Mono<Cliente> getClientById(Integer idCliente) {
        return this.getClientById(idCliente);
    }

    @Override
    public Mono<Cliente> updateClientById(Cliente cliente) {
        return this.save(cliente);
    }

    @Override
    public Flux<Cliente> getAllClients() {
        return this.getAllClients();
    }
}
