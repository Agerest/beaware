package be.aware.service;

import be.aware.domain.Message;
import be.aware.repository.MessageRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public Message getById(Long id) throws NotFoundException {
        return messageRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Message not found, id: " + id));
    }
}
