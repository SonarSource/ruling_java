package example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;

public class HolidayChecker {

  void check() {
    LocalDate.of(2024, 1, 1);
    LocalDate.of(2024, 5, 1);
    LocalDate.of(2024, 7, 14);
    LocalDate.of(2024, 11, 1);
    LocalDate.of(2024, Month.APRIL, 1);
    LocalDate.of(2024, 12, 26);
    LocalDateTime.of(2024, 1, 6, 0, 0);
    LocalDateTime.of(2024, 4, 1, 12, 0);
    LocalDateTime.of(2024, 8, 15, 0, 0);
    LocalDateTime.of(2024, 11, 11, 11, 0);
    LocalDateTime.of(2024, Month.MARCH, 8, 9, 0);
    LocalDateTime.of(2025, 2, 2, 2, 2);
    YearMonth.of(2024, 4);
    YearMonth.of(2024, 12);
    YearMonth.of(2025, 5);
    YearMonth.of(2025, Month.DECEMBER);
    MonthDay.of(7, 14);
    MonthDay.of(11, 1);
    DayOfWeek day = DayOfWeek.FRIDAY;
    DayOfWeek.of(7);
    LocalDate.of(2025, 8, 10);
  }
}