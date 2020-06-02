package be.aware.service;

import be.aware.domain.Server;
import be.aware.domain.Student;
import be.aware.dto.ServerDTO;
import be.aware.mapper.ServerMapper;
import be.aware.repository.ServerRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ServerService {

    private final ServerRepository serverRepository;
    private final StudentService studentService;
    private final ServerMapper serverMapper;

    public Long create(String name, Long ownerId) throws NotFoundException {
        Student student = studentService.getStudentById(ownerId);
        return serverRepository.save(new Server(name, student)).getId();
    }

    public ServerDTO getById(Long id) throws NotFoundException {
        Server server = serverRepository.getByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Server not found, id: " + id));
        return serverMapper.toDto(server);
    }

    public List<ServerDTO> getAll() {
        List<Server> server = serverRepository.findAllByDeletedFalse();
        return serverMapper.toDto(server);
    }
}
