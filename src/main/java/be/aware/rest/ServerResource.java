package be.aware.rest;

import be.aware.dto.channel.ChannelResponseDTO;
import be.aware.dto.server.ServerRequestDTO;
import be.aware.dto.server.ServerResponseDTO;
import be.aware.mapper.ChannelMapper;
import be.aware.service.ChannelService;
import be.aware.service.ServerService;
import be.aware.service.StudentService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/server")
@Slf4j
public class ServerResource {

    private final ServerService serverService;
    private final ChannelService channelService;
    private final StudentService studentService;
    private final ChannelMapper channelMapper;

    @PostMapping("/create")
    public Long createServer(@RequestBody @Valid ServerRequestDTO dto) throws NotFoundException {
        log.debug("Creating new server {}", dto);
        return serverService.create(dto);
    }

    @GetMapping("/{id}")
    public ServerResponseDTO getServerById(@PathVariable("id") Long id) throws NotFoundException {
        log.debug("Getting server by id, id: {}", id);
        return serverService.getById(id);
    }

    @GetMapping("/list")
    public List<ServerResponseDTO> getAllServers() {
        log.debug("Getting server list");
        return serverService.getAll();
    }

    @PostMapping("/{id}/add-channel")
    public void addChannel(@PathVariable("id") Long id,
                           @RequestParam Long channelId) throws NotFoundException {
        log.debug("Adding channel with id {} to server with id {}", channelId, id);
        serverService.addChannel(id, channelService.getById(channelId));
    }

    @PostMapping("/{id}/add-student")
    public void addStudent(@PathVariable("id") Long id,
                           @RequestParam Long studentId) throws NotFoundException {
        log.debug("Adding student with id {} to server with id {}", studentId, id);
        serverService.addStudent(id, studentService.getStudentById(studentId));
    }

    @GetMapping("/{id}/get-channels")
    public List<ChannelResponseDTO> getChannels(@PathVariable("id") Long id) throws NotFoundException {
        log.debug("Getting channels for server with id {}", id);
        return channelMapper.toDto(serverService.getChannels(id));
    }
}
