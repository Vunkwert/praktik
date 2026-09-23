package ru.kafpin.praktik;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    // Шаг для открытия формы (GET запрос)
    @GetMapping("/form")
    public String mainForm(Model model) {
        model.addAttribute("student", new Student());
        return "main-form";
    }

    // Шаг для обработки отправленных данных формы (POST запрос)
    @PostMapping("/form")
    public String processForm(@ModelAttribute Student student, Model model) {
        model.addAttribute("student", student);
        return "result";
    }
}