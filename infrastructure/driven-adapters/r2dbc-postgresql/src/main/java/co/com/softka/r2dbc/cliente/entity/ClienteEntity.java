package co.com.softka.r2dbc.cliente.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Entity
@Table(value = "cliente", schema = "public")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column("idcliente")
    private Integer idCliente;
    @Column("idpersona")
    private Integer idPersona;
    private String password;
    private Boolean estado;
}
