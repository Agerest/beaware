package be.aware.service;

import be.aware.domain.Role;
import be.aware.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getByName(String name) {
        return roleRepository.findByName(name);
    }
}
