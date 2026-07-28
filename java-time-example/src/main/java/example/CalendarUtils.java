package example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;

public class CalendarUtils {

  void compute() {
    LocalDate.of(2024, 2, 14);
    LocalDate.of(2024, 3, 8);
    LocalDate.of(2024, 4, 22);
    LocalDate.of(2024, 5, 9);
    LocalDate.of(2024, Month.JUNE, 21);
    LocalDate.of(2024, 7, 14);
    LocalDateTime.of(2024, 8, 8, 8, 8);
    LocalDateTime.of(2024, 9, 9, 9, 9);
    LocalDateTime.of(2024, 10, 10, 10, 10);
    LocalDateTime.of(2024, 11, 11, 11, 11);
    LocalDateTime.of(2024, Month.DECEMBER, 12, 12, 12);
    LocalDateTime.of(2025, 1, 15, 7, 0);
    YearMonth.of(2025, 2);
    YearMonth.of(2025, 4);
    YearMonth.of(2025, 7);
    YearMonth.of(2025, Month.OCTOBER);
    MonthDay.of(2, 14);
    MonthDay.of(5, 1);
    DayOfWeek day = DayOfWeek.MONDAY;
    DayOfWeek.of(5);
    LocalDate.of(2025, 11, 3);
  }
}