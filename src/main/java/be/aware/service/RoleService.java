package be.aware.service;

import be.aware.domain.Role;
import be.aware.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    @Transactional
    public Role getByName(String name) {
        return roleRepository.findByName(name);
    }
}
