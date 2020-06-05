package be.aware.service;

import be.aware.domain.Image;
import be.aware.domain.Message;
import be.aware.domain.Student;
import be.aware.repository.MessageRepository;
import be.aware.util.ImageUploadUtil;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@AllArgsConstructor
@Service
public class MessageService {

    private final MessageRepository messageRepository;

    @Transactional
    public Message getById(Long id) throws NotFoundException {
        return messageRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("No message found with id: " + id));
    }

    @Transactional
    public Long create(Student owner,
                       String text,
                       Image image) throws IOException {
        Message message = new Message(owner, text, image);
        return messageRepository.save(message).getId();
    }
}
