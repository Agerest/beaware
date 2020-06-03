package be.aware.dto.student;

import be.aware.dto.image.ImageResponseDTO;
import lombok.Data;

@Data
public class StudentResponseDTO {

    private String firstName;
    private String lastName;
    private ImageResponseDTO photo;
}
