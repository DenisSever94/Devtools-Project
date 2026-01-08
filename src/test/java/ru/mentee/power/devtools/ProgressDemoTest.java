package ru.mentee.power.devtools;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mentee.power.ProgressDemo;

@DisplayName("Testing ProgressDemo")
public class ProgressDemoTest {

  @Test
  void mainShouldPrintTotalProgress() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    ProgressDemo.main(new String[]{});
    String output = outputStream.toString().trim();
    assertNotNull(output);
    assertFalse(output.isEmpty());

    System.setOut(System.out);
  }
}
