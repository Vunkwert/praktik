package ru.kafpin.praktik;

public class Student {
    private long id = 13; // Твой ID по умолчанию
    private String name;      // Имя
    private String surname;   // Фамилия
    private String patronymic;// Отчество
    private String email;     // Email
    private int admissionYear = 2023; // Год поступления по умолчанию

    // Конструктор без аргументов (обязательно для Spring POJO)
    public Student() {
    }

    // Геттеры и сеттеры
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAdmissionYear() {
        return admissionYear;
    }

    public void setAdmissionYear(int admissionYear) {
        this.admissionYear = admissionYear;
    }

    // Метод для автоматического формирования группы по условию: «ПИНз-1» + <последние две цифры года>
    public String getGroup() {
        String yearStr = String.valueOf(admissionYear);
        String shortYear = yearStr.length() >= 2 ? yearStr.substring(yearStr.length() - 2) : yearStr;
        return "ПИН-1" + shortYear;
    }

    // Метод для автоматического формирования логина: “student” + <группа> + <id>
    // Приводим к нижнему регистру для красоты: student-pin123-13
    public String getLogin() {
        return ("student-" + getGroup() + "-" + id).toLowerCase();
    }
}