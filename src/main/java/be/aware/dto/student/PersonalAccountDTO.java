package be.aware.dto.student;

import be.aware.dto.ImageResponseDTO;
import lombok.Data;

@Data
public class PersonalAccountDTO {

    private String firstName;
    private String lastName;
    private ImageResponseDTO photo;
    private String username;
    private String email;
}
