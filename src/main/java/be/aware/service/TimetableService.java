package be.aware.service;

import be.aware.domain.Message;
import be.aware.domain.Timetable;
import be.aware.dto.TimetableDTO;
import be.aware.repository.TimetableRepository;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class TimetableService {

    private final TimetableRepository timetableRepository;

    public Long create(TimetableDTO dto) {
        Timetable timetable = new Timetable(dto.getDate(), dto.getType(), dto.getClassroom(), dto.getTeacher());
        return timetableRepository.save(timetable).getId();
    }

    public Timetable getById(Long id) throws NotFoundException {
        return timetableRepository.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new NotFoundException("No timetable found with id: " + id));
    }
}
