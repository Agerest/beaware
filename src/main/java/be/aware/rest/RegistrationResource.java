package be.aware.rest;

import be.aware.dto.UserDTO;
import be.aware.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@AllArgsConstructor
@RestController("api/registration")
public class RegistrationResource {

    private final UserService userService;

    @GetMapping("/user")
    public String showRegistrationForm(WebRequest request, Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "registration";
    }

    @PostMapping("/user")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid UserDTO userDto,
                                            HttpServletRequest request,
                                            Errors errors) {
        userService.registerNewUserAccount(userDto);
        return new ModelAndView("successRegister", "user", userDto);
    }
}
