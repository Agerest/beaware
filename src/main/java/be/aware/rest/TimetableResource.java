package be.aware.rest;

import be.aware.dto.TimetableDTO;
import be.aware.service.TimetableService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("api/timetable")
@Slf4j
public class TimetableResource {

    private final TimetableService timetableService;

    @PostMapping("/create")
    public Long create(@RequestBody @Valid TimetableDTO timetableDTO) {
        log.debug("Creating new timetable: {}", timetableDTO);
        return timetableService.create(timetableDTO);
    }
}
