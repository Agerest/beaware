package be.aware.mapper;

import be.aware.domain.User;
import be.aware.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends AbstractEntityMapper<UserDTO, User> {
}
