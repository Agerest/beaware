package be.aware.dto.student;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class StudentRequestDTO {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    private Long imageId;
}
