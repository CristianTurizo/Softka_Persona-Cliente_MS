package co.com.softka.r2dbc.persona.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(value = "persona", schema = "public")
public class PersonaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("idpersona")
    private Integer idPersona;
    private String nombre;
    private String genero;
    private Integer edad;
    private String identification;
    private String direccion;
    private String telefono;
}
