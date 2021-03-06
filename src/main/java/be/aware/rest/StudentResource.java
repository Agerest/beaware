package be.aware.rest;

import be.aware.domain.Image;
import be.aware.domain.User;
import be.aware.dto.student.PersonalAccountDTO;
import be.aware.dto.student.StudentRequestDTO;
import be.aware.service.ImageService;
import be.aware.service.StudentService;
import be.aware.service.UserService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("api/student")
@Slf4j
public class StudentResource {

    private final StudentService studentService;
    private final ImageService imageService;
    private final UserService userService;

    @PostMapping("/create")
    public Long create(@RequestBody @Valid StudentRequestDTO studentRequestDTO,
                       @AuthenticationPrincipal UserDetails userDetails) throws NotFoundException {
        log.debug("Creating new student: {}", studentRequestDTO);
        Image image = imageService.getById(studentRequestDTO.getImageId());
        User user = userService.getByUsername(userDetails.getUsername());
        return studentService.create(studentRequestDTO.getFirstName(), studentRequestDTO.getLastName(), image, user);
    }

    @GetMapping("/current")
    public Long getCurrentStudent(@AuthenticationPrincipal UserDetails userDetails) throws NotFoundException {
        String username = userDetails.getUsername();
        log.debug("Getting current student, username: {}", username);
        return studentService.getByUsername(username).getId();
    }

    @GetMapping("/{id}")
    public PersonalAccountDTO getStudentInfo(@PathVariable("id") Long id) throws NotFoundException {
        log.debug("Getting student, id: {}", id);
        return studentService.getPersonalInfo(id);
    }
}
