package ru.mentee.power.devtools.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing class StudentList")
public class StudentListTest {

  @Test
  @DisplayName("Должен корректно добавлять студента в список")
  void shouldAddStudentToList() {
    Student ivan = new Student("Иванов Иван", "Москва");
    ArrayList<Student> students = new ArrayList<>();

    students.add(ivan);

    assertEquals(1, students.size(), "Размер должен быть 1");
    assertEquals(ivan, students.getFirst(), "Иван должен быть на позиции 0");
  }

  @Test
  @DisplayName("Добавление name null and city null в коллекцию")
  void shouldAddStudentWithNullFields() {
    Student studentWithNulls = new Student(null, null);
    ArrayList<Student> students = new ArrayList<>();

    students.add(studentWithNulls);

    Student result = students.getFirst();

    assertNotNull(result, "Объект студента не должен быть null");
  }

  @Test
  @DisplayName("Добавление name null в коллекцию")
  void shouldAddStudentWithNameNull() {
    Student studentWithNameNull = new Student(null, "Москва");
    ArrayList<Student> students = new ArrayList<>();

    students.add(studentWithNameNull);

    Student result = students.getFirst();

    assertNotNull(result, "Имя студента не должно быть null");
  }

  @Test
  @DisplayName("Добавление city null в коллекцию")
  void shouldAddStudentWithCityNull() {
    Student studentWithCityNull = new Student("Иван", null);
    ArrayList<Student> students = new ArrayList<>();

    students.add(studentWithCityNull);

    Student result = students.getFirst();

    assertNotNull(result, "Город студента не должен быть null");
  }

  @Test
  @DisplayName("Получить студента по имени и городу")
  void shouldReturnStudentFromSpecificCityAndName() {
    Student student = new Student("Иван", "Москва");
    ArrayList<Student> students = new ArrayList<>();

    students.add(student);

    Student result = students.getFirst();

    assertEquals(result, student);
  }

  @Test
  @DisplayName("Получить всех студентов по городу")
  void shouldReturnStudentsFromSpecificCity() {
    StudentList list = new StudentList();
    list.addStudent(new Student("Иван", "Москва"));
    list.addStudent(new Student("Иван", "Пермь"));
    list.addStudent(new Student("Дмитрий", "Москва"));

    List<Student> result = list.
        getStudentsFromSpecificCityWithVeryLongMethodNameThatExceedsOneHundredTwentyCharacters("Москва");

    assertThat(result)
        .hasSize(2)
        .extracting(Student::name)
        .containsExactlyInAnyOrder("Иван", "Дмитрий");
  }
}