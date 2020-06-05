package be.aware.service;

import be.aware.domain.Image;
import be.aware.repository.ImageRepository;
import be.aware.util.ImageUploadUtil;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@Service
public class ImageService {

    private final ImageRepository imageRepository;

    @Transactional
    public Long create(MultipartFile image) throws IOException {
        byte[] photo = ImageUploadUtil.photoConvert(image);
        return imageRepository.save(new Image(photo)).getId();
    }

    @Transactional
    public Image getById(Long id) throws NotFoundException {
        return imageRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("No image found with id: " + id));
    }
}
