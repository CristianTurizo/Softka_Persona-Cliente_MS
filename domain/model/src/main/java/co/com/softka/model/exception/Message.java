package co.com.softka.model.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {

    PERSON_NOT_FOUND("Persona no encontrada"),
    CLIENT_CREATED_SUCCESSFULLY("Cliente creado con exito"),
    SAVE_CLIENT_ERROR("Error al guardar el cliente"),

    ;

    private final String message;
}
