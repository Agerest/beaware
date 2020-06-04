package be.aware.mapper;

import be.aware.domain.Message;
import be.aware.dto.message.MessageDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MessageMapper extends AbstractEntityMapper<MessageDTO, Message> {
}
