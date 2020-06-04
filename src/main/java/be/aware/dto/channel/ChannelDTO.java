package be.aware.dto.channel;

import be.aware.dto.ImageResponseDTO;
import lombok.Data;

@Data
public class ChannelDTO {

    private Long id;
    private String description;
    private String name;
    private ImageResponseDTO photo;
}
