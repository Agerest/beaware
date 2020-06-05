package be.aware.rest;

import be.aware.dto.TimetableDTO;
import be.aware.dto.channel.ChannelRequestDTO;
import be.aware.dto.channel.ChannelResponseDTO;
import be.aware.dto.message.MessageResponseDTO;
import be.aware.mapper.ChannelMapper;
import be.aware.mapper.MessageMapper;
import be.aware.mapper.TimetableMapper;
import be.aware.service.ChannelService;
import be.aware.service.MessageService;
import be.aware.service.TimetableService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/channel")
@Slf4j
public class ChannelResource {

    private final ChannelService channelService;
    private final MessageService messageService;
    private final ChannelMapper channelMapper;
    private final MessageMapper messageMapper;
    private final TimetableService timetableService;
    private final TimetableMapper timetableMapper;

    @PostMapping("/create")
    public Long createChannel(@RequestBody @Valid ChannelRequestDTO dto) throws IOException, NotFoundException {
        log.debug("Creating new channel: {}", dto);
        return channelService.create(dto);
    }

    @PostMapping("/{id}/add-message")
    public void addMessage(@PathVariable("id") Long id,
                           @RequestParam Long messageId) throws NotFoundException {
        log.debug("Adding message with id {} to channel with id {}", messageId, id);
        channelService.addMessage(id, messageService.getById(id));
    }

    @GetMapping("/{id}")
    public ChannelResponseDTO getChannelById(@PathVariable("id") Long id) throws NotFoundException {
        log.debug("Getting channel by id, id: {}", id);
        return channelMapper.toDto(channelService.getById(id));
    }

    @GetMapping("/{id}/messages")
    public List<MessageResponseDTO> getChannelMessages(@PathVariable("id") Long id) throws NotFoundException {
        log.debug("Getting messages from channel with id: {}", id);
        return messageMapper.toDto(channelService.getMessages(id));
    }

    @PostMapping("/{id}/add-timetable")
    public void addTimetable(@PathVariable("id") Long id,
                             @RequestParam Long timetableId) throws NotFoundException {
        log.debug("Adding timetable with id {} to channel with id {}", timetableId, id);
        channelService.addTimetable(id, timetableService.getById(id));
    }

    @GetMapping("/{id}/timetables")
    public List<TimetableDTO> getChannelTimetables(@PathVariable("id") Long id) throws NotFoundException {
        log.debug("Getting timetables from channel with id: {}", id);
        return timetableMapper.toDto(channelService.getTimetables(id));
    }
}
