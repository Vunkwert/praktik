package ru.kafpin.praktik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kafpin.praktik.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}