package be.aware.dto.channel;

import be.aware.domain.Message;
import lombok.Data;

import java.util.List;

@Data
public class ChannelDTO {

    private String name;
    private byte[] photo;
    private List<Message> messages;
}
