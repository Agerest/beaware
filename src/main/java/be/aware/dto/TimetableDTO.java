package be.aware.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class TimetableDTO {

    @NotEmpty
    private String date;
    @NotEmpty
    private String type;
    @NotEmpty
    private String classroom;
    @NotEmpty
    private String teacher;
}
