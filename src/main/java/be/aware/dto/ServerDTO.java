package be.aware.dto;

import be.aware.dto.channel.ChannelDTO;
import be.aware.dto.student.StudentResponseDTO;
import lombok.Data;

import java.util.List;

@Data
public class ServerDTO {

    private String name;
    private StudentResponseDTO owner;
    private List<StudentResponseDTO> students;
    private List<ChannelDTO> channels;
}
