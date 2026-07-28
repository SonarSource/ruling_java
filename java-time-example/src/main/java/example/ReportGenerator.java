package example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;

public class ReportGenerator {

  void generate() {
    LocalDate.of(2024, 1, 31);
    LocalDate.of(2024, 3, 31);
    LocalDate.of(2024, 6, 30);
    LocalDate.of(2024, 9, 30);
    LocalDate.of(2024, Month.FEBRUARY, 29);
    LocalDate.of(2024, 12, 31);
    LocalDateTime.of(2024, 3, 31, 23, 59);
    LocalDateTime.of(2024, 6, 30, 23, 59);
    LocalDateTime.of(2024, 9, 30, 23, 59);
    LocalDateTime.of(2024, 12, 31, 23, 59);
    LocalDateTime.of(2025, Month.JUNE, 30, 23, 59);
    LocalDateTime.of(2025, 9, 30, 23, 59);
    YearMonth.of(2024, 6);
    YearMonth.of(2024, 9);
    YearMonth.of(2024, 12);
    YearMonth.of(2025, Month.MARCH);
    MonthDay.of(12, 31);
    MonthDay.of(3, 31);
    DayOfWeek day = DayOfWeek.SUNDAY;
    DayOfWeek.of(4);
    LocalDate.of(2025, 11, 30);
  }
}