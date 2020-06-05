package be.aware.rest;

import be.aware.dto.UserDTO;
import be.aware.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("api/registration")
@Slf4j
public class RegistrationResource {

    private final UserService userService;

    @PostMapping("/new-user")
    public ResponseEntity<Object> registerUserAccount(@Valid @RequestBody UserDTO userDto) {
        log.debug("Registration new account, username: {}", userDto.getUsername());
        userService.registerNewUserAccount(userDto);
        return ResponseEntity.ok(userDto);
    }
}
