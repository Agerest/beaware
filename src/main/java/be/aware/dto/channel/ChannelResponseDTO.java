package be.aware.dto.channel;

import be.aware.dto.ImageDTO;
import lombok.Data;

@Data
public class ChannelResponseDTO {

    private Long id;
    private String description;
    private String name;
    private ImageDTO photo;
}
