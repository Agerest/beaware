package be.aware.service;

import be.aware.domain.Image;
import be.aware.domain.Student;
import be.aware.domain.User;
import be.aware.repository.StudentRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public Student getStudentById(Long id) throws NotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student not found, id: " + id));
    }

    public Long create(String firstName,
                       String lastName,
                       Image image,
                       User user) {
        return studentRepository.save(new Student(firstName, lastName, image, user)).getId();
    }

    public Long getByUsername(String username) throws NotFoundException {
        return studentRepository.getByUsername(username)
                .orElseThrow(() -> new NotFoundException("Student not found, username: " + username))
                .getId();
    }
}
