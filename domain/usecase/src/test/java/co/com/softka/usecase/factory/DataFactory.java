package co.com.softka.usecase.factory;

import co.com.softka.model.cliente.Cliente;
import co.com.softka.model.persona.Persona;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DataFactory {
    public Persona createPerson(){
         return Persona.builder()
                .idPersona(1)
                .nombre("Juan Pérez")
                .genero("M")
                .edad(30)
                .identification("1111")
                .direccion("Calle Falsa 123")
                .telefono("111111")
                .build();
    }

    public Cliente createClientForSave(){
        return Cliente.builder()
                .identification("111")
                .password("111")
                .build();
    }

    public Cliente createSavedClient(){
        return Cliente.builder()
                .idCliente(1)
                .idPersona(1)
                .estado(true)
                .password("111")
                .build();
    }
    public Cliente createCompleteClient(){
        return Cliente.builder()
                .idCliente(1)
                .idPersona(1)  // Puedes usar el mismo valor o uno diferente
                .nombre("Juan Pérez")
                .genero("M")
                .edad(30)
                .identification("1111")
                .direccion("Calle Falsa 123")
                .telefono("111111")
                .password("111")
                .estado(true)
                .build();
    }

}
