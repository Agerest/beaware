package be.aware.dto.channel;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ChannelInfoDTO {

    @NotEmpty
    private String name;
    @NotNull
    private MultipartFile photo;
}
