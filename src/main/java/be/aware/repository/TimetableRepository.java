package be.aware.repository;

import be.aware.domain.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TimetableRepository extends JpaRepository<Timetable, Long> {

    Optional<Timetable> findByIdAndDeletedFalse(Long id);
}
