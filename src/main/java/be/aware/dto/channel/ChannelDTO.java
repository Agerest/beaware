package be.aware.dto.channel;

import be.aware.dto.ImageResponseDTO;
import be.aware.dto.MessageDTO;
import lombok.Data;

import java.util.List;

@Data
public class ChannelDTO {

    private Long id;
    private String description;
    private String name;
    private ImageResponseDTO photo;
}
