package ru.mentee.power.devtools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiveCodingDemo {
  private static final Logger LOG = LoggerFactory.getLogger(LiveCodingDemo.class);

  public static void main(String[] args) {
    int[] arrayNumber = {12, 22, 1, 2, 42};

    printFizzBuzz(15);

    try {
      LOG.info("Максимальное число в массиве {}", findMax(arrayNumber));
    } catch (IllegalArgumentException e) {
      LOG.error(e.getMessage());
    }

    try {
      LOG.info("Сумма всех четных чисел в массива: {}", sumEven(arrayNumber));
    } catch (IllegalArgumentException e) {
      LOG.error(e.getMessage());
    }
  }

  public static void printFizzBuzz(int n) {
    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        LOG.info("FizzBuzz");
      } else if (i % 3 == 0) {
        LOG.info("Fizz");
      } else if (i % 5 == 0) {
        LOG.info("Buzz");
      } else {
        LOG.info("Число ({}) ", i);
      }
    }
  }

  public static int sumEven(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("Массив пуст");
    }
    int sum = 0;
    for (int number : numbers) {
      if (number % 2 == 0) {
        sum += number;
      }
    }
    return sum;
  }

  public static int findMax(int[] numbers) {
    if (numbers == null || numbers.length == 0) {
      throw new IllegalArgumentException("Массив пуст");
    }

    int max = numbers[0];
    for (int number : numbers) {
      if (number > max) {
        max = number;
      }
    }
    return max;
  }
}

