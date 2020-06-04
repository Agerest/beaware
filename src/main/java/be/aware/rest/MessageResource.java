package be.aware.rest;

import be.aware.domain.Image;
import be.aware.domain.Student;
import be.aware.dto.message.MessageRequestDTO;
import be.aware.service.ImageService;
import be.aware.service.MessageService;
import be.aware.service.StudentService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("api/message")
@Slf4j
public class MessageResource {

    private final MessageService messageService;
    private final StudentService studentService;
    private final ImageService imageService;

    @PostMapping("/create")
    public Long create(@RequestBody @Valid MessageRequestDTO dto,
                       @AuthenticationPrincipal UserDetails userDetails) throws IOException, NotFoundException {
        log.debug("Creating new message: {}", dto);
        Student student = studentService.getByUsername(userDetails.getUsername());
        Image image = imageService.getById(dto.getImageId());
        return messageService.create(student, dto.getMessage(), image);
    }
}
