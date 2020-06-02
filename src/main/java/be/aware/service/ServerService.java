package be.aware.service;

import be.aware.domain.Channel;
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
        Server server = getServer(id);
        return serverMapper.toDto(server);
    }

    public List<ServerDTO> getAll() {
        List<Server> server = serverRepository.findAllByDeletedFalse();
        return serverMapper.toDto(server);
    }

    public void addChannel(Long id, Channel channel) throws NotFoundException {
        Server server = getServer(id);
        server.getChannels().add(channel);
        serverRepository.save(server);
    }

    private Server getServer(Long id) throws NotFoundException {
        return serverRepository.getByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Server not found, id: " + id));
    }

    public void addStudent(Long id, Student student) throws NotFoundException {
        Server server = getServer(id);
        server.getStudents().add(student);
        serverRepository.save(server);
    }
}
