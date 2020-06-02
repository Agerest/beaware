package be.aware.rest;

import be.aware.dto.ServerDTO;
import be.aware.service.ServerService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/server")
@Slf4j
public class ServerResource {

    private final ServerService serverService;

    @PostMapping("/create")
    public Long createServer(@RequestParam String name,
                             @RequestParam Long ownerId) throws NotFoundException {
        log.debug("Create new server, name: {}, ownerId: {}", name, ownerId);
        return serverService.create(name, ownerId);
    }

    @GetMapping("/{id}")
    public ServerDTO getServerById(@PathVariable("id") Long id) throws NotFoundException {
        log.debug("Getting server by id, id: {}", id);
        return serverService.getById(id);
    }

    @GetMapping("/List")
    public List<ServerDTO> getAllServers() {
        log.debug("Getting server list");
        return serverService.getAll();
    }
}
