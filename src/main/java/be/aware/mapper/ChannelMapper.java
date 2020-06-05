package be.aware.mapper;

import be.aware.domain.Channel;
import be.aware.dto.channel.ChannelResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ChannelMapper extends AbstractEntityMapper<ChannelResponseDTO, Channel> {
}
