package co.com.softka.r2dbc.persona.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(value = "persona", schema = "public")
public class PersonaEntity {
    @Id
    @Column("idpersona")
    private Integer idPersona;
    private String nombre;
    private String genero;
    private Integer edad;
    private String identification;
    private String direccion;
    private String telefono;
}
