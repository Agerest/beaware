package be.aware.dto.image;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

@Data
public class ImageDTO {

    @NotNull
    private MultipartFile image;
}
