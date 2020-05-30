package be.aware.service;

import be.aware.domain.User;
import be.aware.dto.UserDTO;
import be.aware.exception.UserAlreadyExistException;
import be.aware.mapper.UserMapper;
import be.aware.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional
    public User registerNewUserAccount(UserDTO userDto) throws UserAlreadyExistException {
        if (userRepository.existsByEmailAndDeletedFalse(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " + userDto.getEmail());
        }
        return userRepository.save(userMapper.toEntity(userDto));
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmailAndDeletedFalse(email)
                .orElseThrow(() -> new UsernameNotFoundException("No user found with username: "+ email));
    }
}
