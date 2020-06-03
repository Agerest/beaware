package be.aware.dto.channel;

import be.aware.dto.image.ImageResponseDTO;
import be.aware.dto.MessageDTO;
import lombok.Data;

import java.util.List;

@Data
public class ChannelDTO {

    private String name;
    private ImageResponseDTO photo;
    private List<MessageDTO> messages;
}
