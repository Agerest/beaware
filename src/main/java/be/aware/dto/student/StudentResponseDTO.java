package be.aware.dto.student;

import be.aware.dto.ImageDTO;
import lombok.Data;

@Data
public class StudentResponseDTO {

    private String firstName;
    private String lastName;
    private ImageDTO photo;
}
