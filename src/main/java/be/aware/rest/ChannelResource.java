package be.aware.rest;

import be.aware.dto.channel.ChannelDTO;
import be.aware.dto.channel.ChannelInfoDTO;
import be.aware.mapper.ChannelMapper;
import be.aware.service.ChannelService;
import be.aware.service.MessageService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@AllArgsConstructor
@RestController
@RequestMapping("api/channel")
@Slf4j
public class ChannelResource {

    private final ChannelService channelService;
    private final MessageService messageService;
    private final ChannelMapper channelMapper;

    @PostMapping("/create")
    public Long createChannel(@RequestBody ChannelInfoDTO dto) throws IOException, NotFoundException {
        log.debug("Creating new channel: {}", dto);
        return channelService.create(dto);
    }

    @PostMapping("/{id}/add-message")
    public void addMessage(@PathVariable("id") Long id,
                           @RequestParam Long messageId) throws NotFoundException {
        log.debug("Adding message with id {} to server with id {}", messageId, id);
        channelService.addMessage(id, messageService.getById(id));
    }

    @GetMapping("/{id}")
    public ChannelDTO getChannelById(@PathVariable("id") Long id) throws NotFoundException {
        log.debug("Getting channel by id, id: {}", id);
        return channelMapper.toDto(channelService.getById(id));
    }
}
