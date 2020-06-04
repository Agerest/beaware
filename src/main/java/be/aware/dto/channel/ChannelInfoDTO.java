package be.aware.dto.channel;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ChannelInfoDTO {

    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotNull
    private Long imageId;
}
