package be.aware.rest;

import be.aware.dto.UserDTO;
import be.aware.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("api/registration")
@Slf4j
public class RegistrationResource {

    private final UserService userService;

    @PostMapping("/new-user")
    public ResponseEntity<Object> registerUserAccount(@Valid @RequestBody UserDTO userDto) {
        log.debug("Registration new account, userDTO: {}", userDto);
        userService.registerNewUserAccount(userDto);
        return ResponseEntity.ok(userDto);
    }
}
