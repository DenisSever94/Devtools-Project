package ru.mentee.power.devtools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiveCodingDemo {
  private static final Logger LOG = LoggerFactory.getLogger(LiveCodingDemo.class);

  public static void main(String[] args) {
    List<Integer> numbers = new ArrayList<>();
    numbers.add(1);
    numbers.add(2);
    numbers.add(3);
    numbers.add(4);
    numbers.add(5);


    List<String> str = new ArrayList<>();
    str.add("A");
    str.add("D");
    str.add("B");
    str.add("V");
    str.add("G");
    str.add("C");
    str.add("O");

    Collections.sort(numbers);
    Collections.sort(str);
    LiveCodingDemo demo = new LiveCodingDemo();
    LOG.info("{}", demo.findIndex(numbers, 12));
    LOG.info("{}", demo.findIndex(str, "O"));
  }

  public <T> int findIndex(List<? extends Comparable<? super T>> list, T target) {

    int low = 0;
    int high = list.size() - 1;
    while (low <= high) {
      int mid = (low + high) >>> 1;
      Comparable<? super T> midVal = list.get(mid);
      int cmp = midVal.compareTo(target);

      if (cmp < 0) {
        low = mid + 1;
      } else if (cmp > 0) {
        high = mid - 1;
      } else {
        return mid;
      }
    }
    return -(low + 1);
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

