package be.aware.mapper;

import be.aware.domain.Timetable;
import be.aware.dto.TimetableDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TimetableMapper extends AbstractEntityMapper<TimetableDTO, Timetable> {
}
