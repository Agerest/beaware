package be.aware.dto.channel;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ChannelInfoDTO {

    @NotEmpty
    private String name;
    @NotNull
    private Long imageId;
}
