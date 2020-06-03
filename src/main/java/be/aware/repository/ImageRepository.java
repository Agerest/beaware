package be.aware.repository;

import be.aware.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ImageRepository extends JpaRepository<Image, Long> {

    Optional<Image> findByIdAndDeletedFalse(Long id);
}
