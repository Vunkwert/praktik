package ru.kafpin.praktik.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kafpin.praktik.Student;
import ru.kafpin.praktik.repository.StudentRepository;
import ru.kafpin.praktik.repository.UniversityRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository, UniversityRepository universityRepository) {
        this.studentRepository = studentRepository;
        this.universityRepository = universityRepository;
    }

    // 1. Отображение всех студентов
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students-list";
    }

    // 2. Поиск по 3 критериям
    @GetMapping("/search")
    public String searchStudents(@RequestParam(value = "surname", required = false) String surname,
                                 @RequestParam(value = "universityName", required = false) String universityName,
                                 @RequestParam(value = "minGrade", required = false) Double minGrade,
                                 Model model) {
        List<Student> results;
        if (surname != null && !surname.isBlank()) {
            results = studentRepository.findBySurnameContainsIgnoreCase(surname);
        } else if (universityName != null && !universityName.isBlank()) {
            results = studentRepository.findByUniversityNameContainsIgnoreCase(universityName);
        } else if (minGrade != null) {
            results = studentRepository.findByAverageGradeGreaterThanEqual(minGrade);
        } else {
            results = studentRepository.findAll();
        }
        model.addAttribute("students", results);
        return "students-list";
    }

    // 3. Детали студента
    @GetMapping("/details/{id}")
    public String studentDetails(@PathVariable("id") Long id, Model model) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) return "redirect:/students";
        model.addAttribute("student", student.get());
        return "student-details";
    }

    // 4. Форма добавления
    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("universities", universityRepository.findAll());
        return "student-form";
    }

    // 5. Форма редактирования
    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) return "redirect:/students";
        model.addAttribute("student", student.get());
        model.addAttribute("universities", universityRepository.findAll());
        return "student-form";
    }

    // 6. Сохранение с ВАЛИДАЦИЕЙ (@Valid + BindingResult)
    @PostMapping("/save")
    public String saveStudent(@Valid @ModelAttribute("student") Student student,
                              BindingResult bindingResult,
                              Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("universities", universityRepository.findAll());
            return "student-form";
        }
        studentRepository.save(student);
        return "redirect:/students";
    }

    // 7. Удаление
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
        return "redirect:/students";
    }
}