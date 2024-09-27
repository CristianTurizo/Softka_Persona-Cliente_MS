package co.com.softka.model.cliente;

import co.com.softka.model.persona.Persona;
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
public class Cliente extends Persona {
    private Integer idCliente;
    private Integer idPersona;
    private String password;
    private Boolean estado;

}
