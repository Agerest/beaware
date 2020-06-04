package be.aware.mapper;

import be.aware.domain.Student;
import be.aware.dto.student.PersonalAccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface StudentMapper {

    @Mapping(source = "student.user.username", target = "username")
    @Mapping(source = "student.user.email", target = "email")
    PersonalAccountDTO toDto(Student student);
}
