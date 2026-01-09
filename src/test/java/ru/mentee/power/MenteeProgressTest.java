package ru.mentee.power;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenteeProgressTest {

  @Test
  void shouldFormatSummaryWhenProgressCreated() {
    MenteeProgress progress = new MenteeProgress("Alex", 1, 8);
    String result = progress.summary();
    Assertions.assertThat(result).isEqualTo("Sprint 1 -> Alex: planned 8 h");
  }

  @Test
  void shouldDetectReadinessWhenHoursAboveThreshold() {
    MenteeProgress progress = new MenteeProgress("Alex", 1, 4);
    Assertions.assertThat(progress.readyForSprint()).isTrue();
  }

  @Test
  void shouldDetectLackOfReadinessWhenHoursBelowThreshold() {
    MenteeProgress progress = new MenteeProgress("Alex", 1, 2);
    Assertions.assertThat(progress.readyForSprint()).isFalse();
  }
}
