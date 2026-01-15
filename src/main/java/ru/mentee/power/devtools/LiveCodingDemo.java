package ru.mentee.power.devtools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LiveCodingDemo {
  private static final Logger LOG = LoggerFactory.getLogger(LiveCodingDemo.class);

  public static void main(String[] args) {
    printFizzBuzz(15);

  }

  public static void printFizzBuzz(int n) {
    for (int i = 1; i < n; i++) {
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
}
