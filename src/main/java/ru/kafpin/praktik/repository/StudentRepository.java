package ru.kafpin.praktik.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kafpin.praktik.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    //поиск по фамилии (содержит, без учета регистра)
    List<Student> findBySurnameContainsIgnoreCase(String surname);

    //поиск по названию ВУЗа (без учета регистра)
    List<Student> findByUniversityNameContainsIgnoreCase(String universityName);

    //поиск по среднему баллу не ниже указанного
    List<Student> findByAverageGradeGreaterThanEqual(Double minGrade);
}