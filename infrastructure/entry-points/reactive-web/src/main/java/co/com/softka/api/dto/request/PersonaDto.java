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
public class PersonaDto {

    private String nombre;
    private String genero;
    private Integer edad;
    private String identification;
    private String direccion;
    private String telefono;

}
