package be.aware.repository;

import be.aware.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepository extends JpaRepository<Message, Long> {

    Optional<Message> findByIdAndDeletedFalse(Long id);
}
