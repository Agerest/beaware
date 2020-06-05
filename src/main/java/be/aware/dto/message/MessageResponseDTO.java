package be.aware.dto.message;

import be.aware.dto.ImageDTO;
import lombok.Data;

@Data
public class MessageResponseDTO {

    private String message;
    private ImageDTO image;
}
