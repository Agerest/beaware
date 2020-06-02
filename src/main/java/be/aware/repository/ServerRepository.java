package be.aware.repository;

import be.aware.domain.Server;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServerRepository extends JpaRepository<Server, Long> {

    Optional<Server> getByIdAndDeletedFalse(Long id);

    List<Server> findAllByDeletedFalse();
}
