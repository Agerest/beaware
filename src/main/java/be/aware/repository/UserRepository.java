package be.aware.repository;

import be.aware.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByUsernameAndDeletedFalse(String email);

    Optional<User> findByUsernameAndDeletedFalse(String username);
}
