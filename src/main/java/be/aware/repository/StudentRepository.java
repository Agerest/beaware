package be.aware.repository;

import be.aware.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("select s from Student s where s.user.username = :username")
    Optional<Student> getByUsername(@Param("username") String username);
}
