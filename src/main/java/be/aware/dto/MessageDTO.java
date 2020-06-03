package be.aware.dto;

import be.aware.dto.image.ImageResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class MessageDTO {

    private String message;
    private List<ImageResponseDTO> images;
}
