package be.aware.mapper;

import be.aware.domain.Server;
import be.aware.dto.server.ServerResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServerMapper extends AbstractEntityMapper<ServerResponseDTO, Server> {
}
