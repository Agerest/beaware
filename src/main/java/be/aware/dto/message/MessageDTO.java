package be.aware.dto.message;

import be.aware.dto.ImageResponseDTO;
import lombok.Data;

@Data
public class MessageDTO {

    private String message;
    private ImageResponseDTO image;
}
