package be.aware.dto.server;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ServerInfoDTO {

    @NotEmpty
    private String name;
    private String description;
    @NotNull
    private Long ownerId;
}
