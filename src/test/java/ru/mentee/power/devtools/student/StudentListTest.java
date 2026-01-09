package ru.mentee.power.devtools.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing class StudentList")
class StudentListTest {

  @Test
  @DisplayName("Должен корректно добавлять студента в список")
  void shouldAddStudentToList() {
    Student ivan = new Student("Иванов Иван", "Москва");
    StudentList students = new StudentList();

    students.addStudent(ivan);

    List<Student> studentFromMoscow = students.getStudentsByCity("Москва");
    assertThat(studentFromMoscow)
        .hasSize(1)
        .containsExactly(ivan);
  }

  @Test
  @DisplayName("Добавление name null and city null в коллекцию")
  void shouldAddStudentWithNullFields() {
    Student studentWithNulls = new Student(null, null);
    StudentList student = new StudentList();

    student.addStudent(studentWithNulls);

    assertNotNull(student, "Объект студента не должен быть null");
  }

  @Test
  @DisplayName("Добавление null в коллекцию")
  void shouldAddStudentWithNameNull() {

    StudentList students = new StudentList();

    students.addStudent(null);

    assertThat(students.getStudentsByCity("Любой город")).isEmpty();
  }

  @Test
  @DisplayName("Должен вернуть студента по городу")
  void shouldReturnStudentFromSpecificCityAndName() {
    StudentList students = new StudentList();
    students.addStudent(new Student("Иван", "Москва"));

    List<Student> result = students.getStudentsByCity("Москва");

    assertThat(result)
        .hasSize(1)
        .extracting(Student::city)
        .containsExactlyInAnyOrder("Москва");
  }

  @Test
  @DisplayName("Должен возвращать студентов только из указанного города")
  void shouldReturnStudentsFromSpecificCity() {
    StudentList list = new StudentList();
    list.addStudent(new Student("Иван", "Москва"));
    list.addStudent(new Student("Иван", "Пермь"));
    list.addStudent(new Student("Дмитрий", "Москва"));

    List<Student> result = list.getStudentsByCity("Москва");

    assertThat(result)
        .hasSize(2)
        .extracting(Student::name)
        .containsExactlyInAnyOrder("Иван", "Дмитрий");
  }

  @Test
  @DisplayName("Добавить студента в список")
  void shouldAddStudentInList() {
    Student student = new Student("Иван", "Москва");
    List<Student> studentList = new ArrayList<>();
    studentList.add(student);

    assertEquals(1, studentList.size());
    assertTrue(studentList.contains(student));
    assertSame(student, studentList.getFirst());
  }
}