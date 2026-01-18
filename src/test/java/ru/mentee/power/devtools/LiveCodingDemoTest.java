package ru.mentee.power.devtools;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Testing LiveCodingDemo")
class LiveCodingDemoTest {

  @Test
  void mainShouldPrintTotalProgress() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    LiveCodingDemo.main(new String[]{});
    String output = outputStream.toString().trim();
    assertNotNull(output);
    assertFalse(output.isEmpty());

    System.setOut(System.out);
  }

  @Test
  @DisplayName("Должен корректно отработать если список пуст и вернуть -1")
  void shouldReturnIsEmptyCollection() {
    LiveCodingDemo demo = new LiveCodingDemo();
    int target = 5;
    List<Integer> isEmpty = new ArrayList<>();

    assertEquals(-1, demo.findIndex(isEmpty, target));
  }

  @Test
  @DisplayName("Должен корректно отработать если target в списке отсутствует"
      + " и вернуть -5 (5 - 1) = 4 индекс для вставки элемента")
  void shouldReturnNotFoundTargetInCollection() {
    LiveCodingDemo demo = new LiveCodingDemo();
    int target = 5;
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    assertEquals(-5, demo.findIndex(list, target));
  }

  @Test
  @DisplayName("Должен возвращать индекс target")
  void shouldReturnsIndexInSortedCollection() {
    LiveCodingDemo demo = new LiveCodingDemo();
    int target = 3;
    List<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);

    assertEquals(2, demo.findIndex(list, target));
  }

  @Test
  @DisplayName("Должен вернуть 0 для пустого массива")
  void shouldReturnZeroForEmptyArray() {
    assertEquals(0, LiveCodingDemo.sumEven(new int[]{}));
  }

  @Test
  @DisplayName("Должен вернуть сумму для одного четного числа")
  void shouldReturnSumForOneValueInArray() {
    int[] numbers = {1, 2, 3};

    assertEquals(2, LiveCodingDemo.sumEven(numbers));
  }

  @Test
  @DisplayName("Должен вернуть сумму для нескольких четных чисел")
  void shouldReturnSumForArray() {
    int[] numbers = {1, 2, 3, 4, 6};

    assertEquals(12, LiveCodingDemo.sumEven(numbers));
  }

  @Test
  @DisplayName("Должен вернуть Max в массиве")
  void shouldReturnMaxForArray() {
    int[] numbers = {1, 2, 3, 4, 6};

    assertEquals(6, LiveCodingDemo.findMax(numbers));
  }

  @Test
  @DisplayName("Должен вернуть Max в массиве с отрицательными значениями")
  void shouldReturnMaxForNegativeValueArray() {
    int[] numbers = {-1, -2, -3, -4, -6};

    assertEquals(-1, LiveCodingDemo.findMax(numbers));
  }
}
