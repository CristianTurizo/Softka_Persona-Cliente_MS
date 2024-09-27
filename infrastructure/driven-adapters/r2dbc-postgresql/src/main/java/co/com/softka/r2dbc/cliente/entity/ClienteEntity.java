package co.com.softka.r2dbc.cliente.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table(value = "cliente", schema = "public")
public class ClienteEntity {
    @Id
    @Column("idcliente")
    private Integer idCliente;
    @Column("idpersona")
    private Integer idPersona;
    private String password;
    private Boolean estado;
}
