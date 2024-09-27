package co.com.softka.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class ClienteDto extends PersonaDto {

    private Integer idCliente;
    private Integer idPersona;
    private String password;
    private Boolean estado;
}
