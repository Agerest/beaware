package be.aware.dto;

import be.aware.domain.Channel;
import be.aware.domain.Student;
import lombok.Data;

import java.util.List;

@Data
public class ServerDTO {

    private String name;
    private Student owner;
    private List<Student> students;
    private List<Channel> channels;
}
