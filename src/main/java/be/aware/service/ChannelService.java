package be.aware.service;

import be.aware.domain.Channel;
import be.aware.domain.Message;
import be.aware.dto.channel.ChannelInfoDTO;
import be.aware.repository.ChannelRepository;
import be.aware.util.ImageUploadUtil;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@AllArgsConstructor
@Service
public class ChannelService {

    private final ChannelRepository channelRepository;

    public Channel getById(Long id) throws NotFoundException {
        return channelRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("Channel not found, id: " + id));
    }

    public Long create(ChannelInfoDTO dto) throws IOException {
        byte[] photo = ImageUploadUtil.photoConvert(dto.getPhoto());
        return channelRepository.save(new Channel(dto.getName(), photo)).getId();
    }

    public void addMessage(Long id, Message message) throws NotFoundException {
        Channel channel = getById(id);
        channel.getMessages().add(message);
        channelRepository.save(channel);
    }
}
