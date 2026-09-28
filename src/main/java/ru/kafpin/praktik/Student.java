package ru.kafpin.praktik;

public class Student {
    private long id = 13; 
    private String name;      
    private String surname;   
    private String patronymic;
    private String email;     
    private int admissionYear = 2023; 

    //конструктор без аргументов (для Spring POJO)
    public Student() {
    }

    //геттеры и сеттеры
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

    //метод для автоматического формирования группы по условию: «ПИН-1» + <последние две цифры года>
    public String getGroup() {
        String yearStr = String.valueOf(admissionYear);
        String shortYear = yearStr.length() >= 2 ? yearStr.substring(yearStr.length() - 2) : yearStr;
        return "ПИН-1" + shortYear;
    }

    // метод для автоматического формирования логина: “student” + <группа> + <id>
    //приводим к нижнему регистру для красоты
    public String getLogin() {
        return ("student-" + getGroup() + "-" + id).toLowerCase();
    }
}
