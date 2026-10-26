package ru.kafpin.praktik;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.time.LocalDate;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Фамилия обязательна")
    @Size(min = 2, max = 50, message = "Фамилия должна быть от 2 до 50 символов")
    private String surname;

    @NotBlank(message = "Имя обязательно")
    @Size(min = 2, max = 50, message = "Имя должно быть от 2 до 50 символов")
    private String name;

    private String patronymic;

    @NotBlank(message = "Укажите пол")
    private String gender;

    @NotBlank(message = "Укажите национальность")
    private String nationality;

    @NotNull(message = "Укажите рост")
    @Min(value = 50, message = "Рост должен быть не менее 50 см")
    @Max(value = 250, message = "Некорректный рост")
    private Double height;

    @NotNull(message = "Укажите вес")
    @Min(value = 30, message = "Вес должен быть не менее 30 кг")
    @Max(value = 300, message = "Некорректный вес")
    private Double weight;

    @NotNull(message = "Укажите дату рождения")
    @Past(message = "Дата рождения должна быть в прошлом")
    private LocalDate birthDate;

    @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Некорректный формат телефона")
    private String phoneNumber;

    @NotNull(message = "Укажите курс")
    @Min(value = 1, message = "Курс от 1 до 6")
    @Max(value = 6, message = "Курс от 1 до 6")
    private Integer course;

    @NotBlank(message = "Группа обязательна")
    @Column(name = "student_group")
    private String group;

    @NotNull(message = "Укажите средний балл")
    @Min(value = 2, message = "Минимальный балл 2.0")
    @Max(value = 5, message = "Максимальный балл 5.0")
    private Double averageGrade;

    @NotBlank(message = "Специальность обязательна")
    private String specialty;

    // 1. Связь OneToOne с адресом (Каскадное сохранение и удаление)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @Valid
    private Address address = new Address();

    // 2. Связь ManyToOne с ВУЗом
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id")
    private University university;

    public Student() {}

    // Геттеры и сеттеры для всех полей
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPatronymic() { return patronymic; }
    public void setPatronymic(String patronymic) { this.patronymic = patronymic; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public Double getHeight() { return height; }
    public void setHeight(Double height) { this.height = height; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(LocalDate birthDate) { this.birthDate = birthDate; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public Integer getCourse() { return course; }
    public void setCourse(Integer course) { this.course = course; }

    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    public Double getAverageGrade() { return averageGrade; }
    public void setAverageGrade(Double averageGrade) { this.averageGrade = averageGrade; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }

    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    public University getUniversity() { return university; }
    public void setUniversity(University university) { this.university = university; }
}