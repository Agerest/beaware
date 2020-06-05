package be.aware.service;

import be.aware.domain.Channel;
import be.aware.domain.Server;
import be.aware.domain.Student;
import be.aware.dto.server.ServerRequestDTO;
import be.aware.dto.server.ServerResponseDTO;
import be.aware.mapper.ServerMapper;
import be.aware.repository.ServerRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class ServerService {

    private final ServerRepository serverRepository;
    private final StudentService studentService;
    private final ServerMapper serverMapper;

    @Transactional
    public Long create(ServerRequestDTO dto) throws NotFoundException {
        Student student = studentService.getStudentById(dto.getOwnerId());
        return serverRepository.save(new Server(dto.getName(), student, dto.getDescription())).getId();
    }

    @Transactional
    public ServerResponseDTO getById(Long id) throws NotFoundException {
        Server server = getServer(id);
        return serverMapper.toDto(server);
    }

    @Transactional
    public List<ServerResponseDTO> getAll() {
        List<Server> server = serverRepository.findAllByDeletedFalse();
        return serverMapper.toDto(server);
    }

    @Transactional
    public void addChannel(Long id, Channel channel) throws NotFoundException {
        Server server = getServer(id);
        server.getChannels().add(channel);
        serverRepository.save(server);
    }

    private Server getServer(Long id) throws NotFoundException {
        return serverRepository.getByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("No server found with id: " + id));
    }

    @Transactional
    public void addStudent(Long id, Student student) throws NotFoundException {
        Server server = getServer(id);
        server.getStudents().add(student);
        serverRepository.save(server);
    }

    @Transactional
    public List<Channel> getChannels(Long id) throws NotFoundException {
        Server server = getServer(id);
        return server.getChannels();
    }
}
