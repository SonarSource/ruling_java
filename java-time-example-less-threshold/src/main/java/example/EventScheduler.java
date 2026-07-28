package example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.YearMonth;

public class EventScheduler {

  void plan() {
    LocalDate.of(2024, Month.JANUARY, 20);
    LocalDate.of(2024, Month.FEBRUARY, 28);
    LocalDate.of(2024, Month.MARCH, 31);
    LocalDate.of(2024, Month.APRIL, 15);
    LocalDate.of(2024, Month.AUGUST, 20);
    LocalDate.of(2024, Month.SEPTEMBER, 10);
    LocalDateTime.of(2024, Month.MAY, 5, 5, 5);
    LocalDateTime.of(2024, Month.JUNE, 6, 6, 6);
    LocalDateTime.of(2024, 7, 7, 7, 7);
    LocalDateTime.of(2024, 10, 15, 14, 0);
    LocalDateTime.of(2024, Month.JANUARY, 30, 18, 0);
    LocalDateTime.of(2025, 3, 3, 3, 3);
    YearMonth.of(2024, 5);
    YearMonth.of(2024, 8);
    YearMonth.of(2025, 3);
    YearMonth.of(2025, Month.JULY);
    MonthDay.of(6, 21);
    MonthDay.of(9, 22);
    DayOfWeek day = DayOfWeek.WEDNESDAY;
    DayOfWeek.of(6);
    LocalDate.of(2025, 10, 15);
  }
}