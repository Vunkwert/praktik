package ru.kafpin.praktik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kafpin.praktik.University;

public interface UniversityRepository extends JpaRepository<University, Long> {
}