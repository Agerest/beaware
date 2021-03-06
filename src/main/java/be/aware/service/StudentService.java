package be.aware.service;

import be.aware.domain.Image;
import be.aware.domain.Student;
import be.aware.domain.User;
import be.aware.dto.student.PersonalAccountDTO;
import be.aware.mapper.StudentMapper;
import be.aware.repository.StudentRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Transactional
    public Student getStudentById(Long id) throws NotFoundException {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No student found with id: " + id));
    }

    @Transactional
    public Long create(String firstName,
                       String lastName,
                       Image image,
                       User user) {
        return studentRepository.save(new Student(firstName, lastName, image, user)).getId();
    }

    @Transactional
    public Student getByUsername(String username) throws NotFoundException {
        return studentRepository.getByUsername(username)
                .orElseThrow(() -> new NotFoundException("No student found with username: " + username));
    }

    @Transactional
    public PersonalAccountDTO getPersonalInfo(Long id) throws NotFoundException {
        Student student = getStudentById(id);
        return studentMapper.toDto(student);
    }
}
