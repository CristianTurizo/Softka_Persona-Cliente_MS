package co.com.softka.api;

import co.com.softka.api.dto.request.ClienteDto;
import co.com.softka.api.dto.response.GenericResponse;
import co.com.softka.api.mapper.ClientMapper;
import co.com.softka.model.exception.Message;
import co.com.softka.usecase.cliente.ClienteUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class Handler {
    private final ClienteUseCase clienteUseCase;
    private final ClientMapper mapper;

    public Mono<ServerResponse> saveClient(ServerRequest serverRequest) {
        return serverRequest.bodyToMono(ClienteDto.class)
                .doFirst(() -> log.info("Inciando guadado del usuario"))
                .map(this.mapper::toClientDomain)
                .flatMap(this.clienteUseCase::saveClient)
                .map(this.mapper::toDto)
                .flatMap(clientDto -> this.buildResponse(clientDto, Message.CLIENT_CREATED_SUCCESSFULLY, null))
                .doOnError(e -> log.error(Message.SAVE_CLIENT_ERROR.getMessage()))
                .onErrorResume(error -> this.buildResponse(null, Message.SAVE_CLIENT_ERROR, error.getMessage()));
    }

    private <T> Mono<ServerResponse> buildResponse(T data, Message responseMessage, String error) {
        GenericResponse<T> response = new GenericResponse<>(
                data,
                error,
                responseMessage.getMessage());
        return ServerResponse.ok().bodyValue(response);
    }

    public Mono<ServerResponse> updateClient(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> getClientById(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }

    public Mono<ServerResponse> getAllClients(ServerRequest serverRequest) {
        return ServerResponse.ok().bodyValue("");
    }
}
