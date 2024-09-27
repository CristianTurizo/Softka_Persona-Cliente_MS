package co.com.softka.model.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Message {

    PERSON_NOT_FOUND("Persona no encontrada"),
    CLIENT_NOT_FOUND("Cliente no encontrado"),
    CLIENT_CREATED_SUCCESSFULLY("Cliente creado con exito"),
    CLIENT_FOUND_SUCCESSFULLY("Cliente encontrado con exito"),
    SAVE_CLIENT_ERROR("Error saving client"),
    FIND_CLIENT_ERROR("Error finding client"),

    ;

    private final String message;
}
