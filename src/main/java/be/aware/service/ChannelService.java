package be.aware.service;

import be.aware.domain.Channel;
import be.aware.domain.Image;
import be.aware.domain.Message;
import be.aware.domain.Timetable;
import be.aware.dto.channel.ChannelRequestDTO;
import be.aware.repository.ChannelRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;

@AllArgsConstructor
@Service
public class ChannelService {

    private final ChannelRepository channelRepository;
    private final ImageService imageService;

    @Transactional
    public Channel getById(Long id) throws NotFoundException {
        return channelRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("No channel found with id: " + id));
    }

    @Transactional
    public Long create(ChannelRequestDTO dto) throws IOException, NotFoundException {
        Image image = imageService.getById(dto.getImageId());
        return channelRepository.save(new Channel(dto.getName(), image, dto.getDescription())).getId();
    }

    @Transactional
    public void addMessage(Long id, Message message) throws NotFoundException {
        Channel channel = getById(id);
        channel.getMessages().add(message);
        channelRepository.save(channel);
    }

    @Transactional
    public List<Message> getMessages(Long id) throws NotFoundException {
        Channel channel = getById(id);
        return channel.getMessages();
    }

    @Transactional
    public void addTimetable(Long id, Timetable timetable) throws NotFoundException {
        Channel channel = getById(id);
        channel.getTimetables().add(timetable);
        channelRepository.save(channel);
    }

    @Transactional
    public List<Timetable> getTimetables(Long id) throws NotFoundException {
        Channel channel = getById(id);
        return channel.getTimetables();
    }
}
