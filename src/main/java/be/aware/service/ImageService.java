package be.aware.service;

import be.aware.domain.Image;
import be.aware.dto.image.ImageDTO;
import be.aware.repository.ImageRepository;
import be.aware.util.ImageUploadUtil;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public Long create(MultipartFile image) throws IOException {
        byte[] photo = ImageUploadUtil.getImage(image);
        return imageRepository.save(new Image(photo)).getId();
    }

    public Image getById(Long id) throws NotFoundException {
        return imageRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Image not found, id: " + id));
    }
}
