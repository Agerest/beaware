package be.aware.dto.message;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MessageRequestDTO {

    @NotEmpty
    private String message;
    private Long imageId;
}
