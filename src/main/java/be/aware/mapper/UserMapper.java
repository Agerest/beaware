package be.aware.mapper;

import be.aware.domain.User;
import be.aware.dto.UserDTO;
import org.mapstruct.Mapper;

public interface UserMapper extends AbstractEntityMapper<UserDTO, User> {
}
