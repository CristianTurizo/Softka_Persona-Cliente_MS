package co.com.softka.api.mapper;

import co.com.softka.api.dto.request.ClienteDto;
import co.com.softka.model.cliente.Cliente;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        imports = {LocalDateTime.class, DateTimeFormatter.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {


    Cliente toClientDomain(ClienteDto clienteDto);

    ClienteDto toDto(Cliente cliente);
}
