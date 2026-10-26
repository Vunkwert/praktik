INSERT INTO universities (id, name) VALUES (1, 'МГТУ');
INSERT INTO universities (id, name) VALUES (2, 'МГУ');

INSERT INTO addresses (id, postal_code, country, region, district, city, street, house, apartment)
VALUES (1, '300000', 'Россия', 'Тульская обл.', 'Центральный', 'Тула', 'Ленина', '10', '25');

INSERT INTO addresses (id, postal_code, country, region, district, city, street, house, apartment)
VALUES (2, '101000', 'Россия', 'Московская обл.', 'Северный', 'Москва', 'Тверская', '15', '102');

INSERT INTO students (surname, name, patronymic, gender, nationality, height, weight, birth_date, phone_number, course, student_group, average_grade, specialty, address_id, university_id)
VALUES ('Иванов', 'Иван', 'Иванович', 'Мужской', 'Русский', 180.5, 75.0, '2002-05-15', '+79991112233', 4, 'ПИН-120', 4.8, 'Программная инженерия', 1, 1);

INSERT INTO students (surname, name, patronymic, gender, nationality, height, weight, birth_date, phone_number, course, student_group, average_grade, specialty, address_id, university_id)
VALUES ('Петрова', 'Анна', 'Сергеевна', 'Женский', 'Русская', 165.0, 52.0, '2003-08-20', '+79992223344', 3, 'ПИН-121', 4.2, 'Информационные системы', 2, 2);