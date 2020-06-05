package be.aware.dto.server;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ServerRequestDTO {

    @NotEmpty
    private String name;
    private String description;
    @NotNull
    private Long ownerId;
}
