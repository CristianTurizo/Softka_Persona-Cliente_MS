package co.com.softka.model.persona;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
public class Persona {
    private Integer idPersona;
    private String nombre;
    private String genero;
    private Integer edad;
    private String identification;
    private String direccion;
    private String telefono;

}
