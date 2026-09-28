package ru.kafpin.praktik.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kafpin.praktik.Student;
import ru.kafpin.praktik.repository.StudentRepository;

import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    //отображение списка всех студентов
    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "students-list";
    }

    //детальная информация об одном студенте (с проверкой существования)
    @GetMapping("/details/{id}")
    public String studentDetails(@PathVariable("id") Long id, Model model) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            return "redirect:/students";
        }
        model.addAttribute("student", student.get());
        return "student-details";
    }

    //форма добавления нового студента
    @GetMapping("/create")
    public String createStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "student-form";
    }

    //форма редактирования студента (с проверкой существования)
    @GetMapping("/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isEmpty()) {
            return "redirect:/students";
        }
        model.addAttribute("student", student.get());
        return "student-form";
    }

    //сохранение (добавление или обновление)
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentRepository.save(student);
        return "redirect:/students";
    }

    //удаление по айди (с проверкой существования)
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        }
        return "redirect:/students";
    }
}