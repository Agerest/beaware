package be.aware.service;

import be.aware.domain.Student;
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
}
